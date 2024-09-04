package com.example.CurdOfUsersWithSolid.repository;

import com.example.CurdOfUsersWithSolid.dtos.RequestDto;
import com.example.CurdOfUsersWithSolid.dtos.ResponseDto;
import com.example.CurdOfUsersWithSolid.dtos.UserResponseDto;
import com.example.CurdOfUsersWithSolid.entity.User;
import com.example.CurdOfUsersWithSolid.mappers.GenericMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Component
public class UserRepositoryServiceImpl implements UserRepositoryService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private GenericMapper mapper;

    @Override
    public List<ResponseDto> getAllUsers() {
        return repository.findAll()
                .stream().map(e -> (ResponseDto) mapper.toDto(e))
                .toList();
    }

    @Override
    public ResponseDto saveUser(RequestDto req) {
        User entity = (User) mapper.toEntity(req);
        repository.save(entity);

        return (ResponseDto) mapper.toDto(entity);
    }

    @Override
    public User updateUser(RequestDto dto, User user) {
        return null;
    }
}
