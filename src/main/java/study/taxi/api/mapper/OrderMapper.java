package study.taxi.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import study.taxi.api.dto.OrderDto;
import study.taxi.data.entity.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrderDto(List<Order> orders);
}
