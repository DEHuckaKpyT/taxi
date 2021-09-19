package study.taxi.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import study.taxi.data.entity.*;
import study.taxi.data.repository.*;
import study.taxi.service.orderService.OrderService;
import study.taxi.service.userService.UserService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class NeedRunner implements ApplicationRunner {

    private final OrderService orderService;
    private final CarRepository carRepository;
    private final DriverRepository driverRepository;
    private final CarColorRepository carColorRepository;
    private final CarTypeRepository carTypeRepository;
    private final UserRepository userRepository;
    private final OptionRepository optionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        User user = userRepository.findById(UUID.fromString("3564eed3-807b-4763-b941-c82467a7cd45")).orElse(null);
//        Car car = carRepository.findById(UUID.fromString("649bfa0b-1b6b-4553-a04b-1fe8f43056cc")).orElse(null);
//        Driver driver = driverRepository.findById(UUID.fromString("c2f3ab62-7984-47ab-b983-9eefca7239f6")).orElse(null);
//        CarType carType = carTypeRepository.findById(UUID.fromString("d1e36355-d845-4fe4-b7c9-7bdba7aa8fbb")).orElse(null);
//        CarType carType2 = carTypeRepository.findById(UUID.fromString("39e093ba-5971-44dc-bcd0-83720557a315")).orElse(null);
//        Option option = optionRepository.findById(UUID.fromString("9c449a12-e987-4fdd-b3f8-dc5fcdd79fa0")).orElse(null);
//        Option option2 = optionRepository.findById(UUID.fromString("c3a5eb77-293f-4fc9-96e7-2b2697b8f5ad")).orElse(null);

//        Car car = Car.builder()
//                .carId(UUID.randomUUID())
//                .color(carColor)
//                .name("toyota")
//                .number("oo001o")
//                .CountOfPassengers(4)
//                .type(carType)
//                .build();
//        carRepository.save(car);
//
//        Driver driver = Driver.builder()
//                .driverId(UUID.randomUUID())
//                .car(car)
//                .firstname("fn")
//                .lastname("ln")
//                .passport("passport")
//                .password("pass")
//                .build();
//        driverRepository.save(driver);

//        User user = User.builder()
//                .userId(UUID.randomUUID())
//                .firstname("fn")
//                .lastname("ln")
//                .number("numb")
//                .password("pass")
//                .email("mail")
//                .build();
//
//        Order order = Order.builder()
//                .orderId(UUID.randomUUID())
//                .createDateTime(LocalDateTime.now())
//                .comment("com")
//                .driver(driver)
//                .otherNumber("123")
//                .points("p1p2p3")
//                .price(134)
//                .tip(0)
//                .options(Set.of(option, option2))
//                .types(Set.of(carType, carType2))
//                .user(user)
//                .usingCar(car)
//                .build();
//
//        orderService.create(order);
    }
}
