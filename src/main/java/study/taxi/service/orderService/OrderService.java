package study.taxi.service.orderService;

import study.taxi.api.dto.CreateOrderDto;
import study.taxi.api.dto.OrderDto;
import study.taxi.api.dto.OrderProjection;
import study.taxi.data.entity.Order;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<Order> getAll();

    Order create(CreateOrderDto createOrderDto);

    int getPrice(CreateOrderDto createOrderDto);

    List<OrderProjection> getHistoryByUserId(UUID userId) throws FileNotFoundException;

    Order get(UUID orderId);
}
