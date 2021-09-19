package study.taxi.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import study.taxi.api.dto.OrderLogDto;
import study.taxi.data.entity.OrderLog;

import java.util.List;

@Mapper
public interface OrderLogMapper {

    OrderLogMapper INSTANCE = Mappers.getMapper(OrderLogMapper.class);

    @Mappings({
            @Mapping(target = "logId", source = "logId"),
            @Mapping(target = "order", source = "order"),
            @Mapping(target = "changeDateTime", source = "changeDateTime"),
            @Mapping(target = "state", source = "state")
    })
    OrderLogDto toOrderLogDto(OrderLog orderLog);

    List<OrderLogDto> toOrderLogDto(List<OrderLog> orderLogs);
}
