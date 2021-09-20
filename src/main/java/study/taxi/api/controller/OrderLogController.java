package study.taxi.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.taxi.api.dto.OrderLogDto;
import study.taxi.api.mapper.OrderLogMapper;
import study.taxi.service.orderLogService.OrderLogService;

import java.util.List;

@RestController
@RequestMapping("order-log")
@RequiredArgsConstructor
public class OrderLogController {

    private final OrderLogService orderLogService;

    @GetMapping("list")
    List<OrderLogDto> getAll() {
        return OrderLogMapper.INSTANCE.toOrderLogDto(orderLogService.getAll());
    }
}
