package study.taxi.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import study.taxi.api.dto.OptionDto;
import study.taxi.data.entity.Option;

import java.util.List;

@Mapper
public interface OptionMapper {

    OptionMapper INSTANCE = Mappers.getMapper(OptionMapper.class);

    OptionDto toOptionDto(Option option);

    List<OptionDto> toOptionDto(List<Option> options);
}
