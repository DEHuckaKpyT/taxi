package study.taxi.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import study.taxi.api.dto.OrderDto;
import study.taxi.data.entity.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mappings({
            @Mapping(target = "orderId", source = "orderId"),
            @Mapping(target = "createDateTime", source = "createDateTime"),
            @Mapping(target = "points", source = "points"),
            @Mapping(target = "price", source = "price"),
            @Mapping(target = "comment", source = "comment"),
            @Mapping(target = "tip", source = "tip"),
            @Mapping(target = "otherNumber", source = "otherNumber"),
            @Mapping(target = "driver", source = "driver"),
            @Mapping(target = "user", source = "user"),
            @Mapping(target = "usingCar", source = "usingCar"),
            @Mapping(target = "types", source = "types"),
            @Mapping(target = "options", source = "options")
    })
    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrderDto(List<Order> orders);
}
