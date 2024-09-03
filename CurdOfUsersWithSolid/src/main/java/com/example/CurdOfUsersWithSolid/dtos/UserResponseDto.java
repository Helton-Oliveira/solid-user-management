package com.example.CurdOfUsersWithSolid.dtos;

public record UserResponseDto(
        Long id,
        String name,
        String email,
        String cpf,
        String phone
) implements ResponseDto{
}
