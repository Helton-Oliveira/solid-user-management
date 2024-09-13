package com.example.CurdOfUsersWithSolid.adapters.mapper;

import com.example.CurdOfUsersWithSolid.adapters.repository.UserEntity;
import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class MapperAdapterImpl implements MapperAdapater {
    @Override
    public UserDomain toDomain(String name, String email, String password, String cpf, String phone) {
        return new UserDomain(name, email, password, cpf, phone);
    }

    @Override
    public UserEntity toEntity(String name, String email, String password, String cpf, String phone) {
        return new UserEntity(name, email, password, cpf, phone);
    }
}
