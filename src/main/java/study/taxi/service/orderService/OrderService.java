package study.taxi.service.orderService;

import study.taxi.api.dto.CreateOrderDto;
import study.taxi.data.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order create(CreateOrderDto createOrderDto);

    int getPrice(CreateOrderDto createOrderDto);
}
