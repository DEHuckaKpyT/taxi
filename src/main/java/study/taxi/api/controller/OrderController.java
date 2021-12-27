package study.taxi.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import study.taxi.api.dto.CreateOrderDto;
import study.taxi.api.dto.OrderDto;
import study.taxi.api.dto.PriceDto;
import study.taxi.api.mapper.OrderMapper;
import study.taxi.data.entity.Order;
import study.taxi.service.orderService.OrderService;
import study.taxi.service.userService.UserService;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @GetMapping("list")
    List<OrderDto> getAll() {
        return OrderMapper.INSTANCE.toOrderDto(orderService.getAll());
    }

    @PostMapping("create")
    OrderDto create(@RequestBody CreateOrderDto createOrderDto, Authentication authentication) {
        if (authentication != null){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            createOrderDto.setUser(userService.getUserByUsername(userDetails.getUsername()));
        }

        return OrderMapper.INSTANCE.toOrderDto(orderService.create(createOrderDto));
    }

    @PostMapping("getprice")
    PriceDto getPrice(@RequestBody CreateOrderDto createOrderDto){
        return new PriceDto(orderService.getPrice(createOrderDto));
    }
}
