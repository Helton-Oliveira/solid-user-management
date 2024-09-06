package com.example.CurdOfUsersWithSolid.dtos;

public interface OutputDto {
    UserResponseDto create(Long id, String name, String email, String cpf, String phone);
}
