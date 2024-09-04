package com.example.CurdOfUsersWithSolid.repository;

import com.example.CurdOfUsersWithSolid.dtos.RequestDto;
import com.example.CurdOfUsersWithSolid.dtos.ResponseDto;
import com.example.CurdOfUsersWithSolid.dtos.UserResponseDto;
import com.example.CurdOfUsersWithSolid.entity.User;
import com.example.CurdOfUsersWithSolid.mappers.GenericMapper;
import com.example.CurdOfUsersWithSolid.mappers.UserMapperImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class UserRepositoryServiceImpl implements UserRepositoryService {

    private UserRepository repository;

    private GenericMapper<User> mapper;

    @Autowired
    public UserRepositoryServiceImpl(UserRepository repository, UserMapperImpl mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ResponseDto> getAllUsers() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDto saveUser(RequestDto req) {
        User entity = mapper.toEntity(req);
        repository.save(entity);

        return mapper.toDto(entity);
    }

    @Override
    public ResponseDto updateUser(RequestDto dto, User user) {
        return null;
    }
}
