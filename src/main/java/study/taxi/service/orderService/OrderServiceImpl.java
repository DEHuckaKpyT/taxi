package study.taxi.service.orderService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.taxi.api.dto.CreateOrderDto;
import study.taxi.api.exception.CustomException;
import study.taxi.data.entity.Option;
import study.taxi.data.entity.User;
import study.taxi.data.repository.OrderRepository;
import study.taxi.data.entity.Order;
import study.taxi.service.OptionService;
import study.taxi.service.TypeService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final TypeService typeService;
    private final OptionService optionService;

    double pricePerKm = 40;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Order create(CreateOrderDto createOrderDto) {
        checkOrder(createOrderDto);

        Order order = getOrder(createOrderDto);

        return orderRepository.save(order);
    }

    @Override
    public int getPrice(CreateOrderDto createOrderDto) {
        double totalCost = 0;
        Set<Option> options = new HashSet<>();
        for (var opt : createOrderDto.getOptions()) {
            if (opt.isValue()) options.add(optionService.getOption(opt.getOptionName()));
        }
        if (Objects.equals(createOrderDto.getDistance(), "") || createOrderDto.getDistance() == null)
            throw new CustomException("Маршрут не построен");

        totalCost = getKmByDistance(createOrderDto.getDistance()) * pricePerKm;

        totalCost = totalCost * typeService.getType(createOrderDto.getType()).getCoefficient();

        for (Option option : options) {
            totalCost += option.getAdditionalPrice();
        }

        return (int) totalCost;
    }

    void checkOrder(CreateOrderDto createOrderDto) {
        if (Objects.equals(createOrderDto.getDistance(), "") || createOrderDto.getDistance() == null)
            throw new CustomException("Маршрут не построен");
        if (createOrderDto.getUser() == null && (createOrderDto.getOtherNumber() == null || createOrderDto.getOtherNumber().isEmpty()))
            throw new CustomException("Не введён номер");
    }

    Order getOrder(CreateOrderDto createOrderDto) {
        Set<Option> options = new HashSet<>();
        for (var opt : createOrderDto.getOptions()) {
            if (opt.isValue()) options.add(optionService.getOption(opt.getOptionName()));
        }

        return Order.builder()
                    .createDateTime(LocalDateTime.now())
                    .points(createOrderDto.getAddressFrom() + "; " + createOrderDto.getAddressTo())
                    .price(getPrice(createOrderDto))
                    .comment(createOrderDto.getComment())
                    .tip(createOrderDto.getTip())
                    .otherNumber(createOrderDto.getOtherNumber())
                    .type(typeService.getType(createOrderDto.getType()))
                    .options(options)
                    .build();
    }

    double getKmByDistance(String distance) {
//        String dist = distance.replaceAll(" ", "");

        if (distance.charAt(distance.length() - 2) == 'к') {
            char c = distance.charAt(distance.length() - 3);
            String dist = distance.replace(c, '!');
            dist = dist.replace("!", "").replace(",",".");
            dist = dist.substring(0, dist.length() - 2);
            return Double.parseDouble(dist);
        } else {
            throw new CustomException("Меньше километра не надо, пожалуйста :)");
        }
    }
}
