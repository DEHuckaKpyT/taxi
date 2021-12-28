package study.taxi.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import study.taxi.api.dto.CreateOrderDto;
import study.taxi.api.dto.OrderDto;
import study.taxi.api.dto.OrderProjection;
import study.taxi.api.dto.PriceDto;
import study.taxi.api.exception.CustomException;
import study.taxi.api.mapper.OrderMapper;
import study.taxi.data.entity.Order;
import study.taxi.service.orderService.OrderService;
import study.taxi.service.userService.UserService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

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

        int i = 0;
        i++;
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

    @GetMapping("history")
    List<OrderProjection> getUserHistory(Authentication authentication) throws FileNotFoundException {
        if (authentication == null) throw new CustomException("Пользователь не авторизован");

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UUID userId = userService.getUserByUsername(userDetails.getUsername()).getUserId();
        return orderService.getHistoryByUserId(userId);
    }

    @GetMapping("{orderId}")
    OrderDto getOrder(@PathVariable UUID orderId){
        return OrderMapper.INSTANCE.toOrderDto(orderService.get(orderId));
    }
}
