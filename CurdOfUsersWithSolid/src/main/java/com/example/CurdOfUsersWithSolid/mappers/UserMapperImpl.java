package com.example.CurdOfUsersWithSolid.mappers;

import com.example.CurdOfUsersWithSolid.dtos.RequestDto;
import com.example.CurdOfUsersWithSolid.dtos.ResponseDto;
import com.example.CurdOfUsersWithSolid.dtos.UserResponseDto;
import com.example.CurdOfUsersWithSolid.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements GenericMapper<User> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public User toEntity(RequestDto dto) {
        return mapper.convertValue(dto, User.class);
    }

    @Override
    public UserResponseDto toDto(User entity) {
        return mapper.convertValue(entity, UserResponseDto.class);
    }

}
