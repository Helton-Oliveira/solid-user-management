package com.example.CurdOfUsersWithSolid.adapters.mapper;

import com.example.CurdOfUsersWithSolid.adapters.repository.UserEntity;
import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;

public interface UserMapper {
    UserDomain toDomain(Long id, String name, String email, String password, String cpf, String phone);
    UserEntity toEntity(String name, String email, String password, String cpf, String phone);
}
