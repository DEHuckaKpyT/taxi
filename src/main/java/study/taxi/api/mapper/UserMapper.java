package study.taxi.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import study.taxi.api.argument.CreateUserArgument;
import study.taxi.api.dto.CreateUserDto;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    CreateUserArgument toCreateUserArgument(CreateUserDto createUserDto);
}
