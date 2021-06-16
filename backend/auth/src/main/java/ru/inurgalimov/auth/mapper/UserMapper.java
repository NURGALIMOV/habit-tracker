package ru.inurgalimov.auth.mapper;

import org.mapstruct.Mapper;
import ru.inurgalimov.auth.dto.User;
import ru.inurgalimov.auth.entity.UserEntity;

@Mapper
public interface UserMapper {

    User toDto(UserEntity entity);

    UserEntity toEntity(User dto);

}
