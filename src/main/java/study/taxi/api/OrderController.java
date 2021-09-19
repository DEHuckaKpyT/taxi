package study.taxi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.taxi.api.dto.OrderDto;
import study.taxi.api.mapper.OrderMapper;
import study.taxi.service.orderService.OrderService;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("list")
    List<OrderDto> getAll() {
        return OrderMapper.INSTANCE.toOrderDto(orderService.getAll());
    }

    @PostMapping("create")
    void create() {
    }
}
