package com.example.CurdOfUsersWithSolid.adapters.mapper;

import com.example.CurdOfUsersWithSolid.adapters.repository.UserEntity;
import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDomain toDomain(Long id, String name, String email, String password, String cpf, String phone) {
        return new UserDomain(id, name, email, password, cpf, phone);
    }

    @Override
    public UserEntity toEntity(String name, String email, String password, String cpf, String phone) {
        return new UserEntity(name, email, password, cpf, phone);
    }
}
