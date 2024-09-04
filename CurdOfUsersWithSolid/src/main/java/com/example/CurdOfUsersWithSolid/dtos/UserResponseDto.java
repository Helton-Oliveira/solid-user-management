package com.example.CurdOfUsersWithSolid.dtos;

public record UserResponseDto(
        Long id,
        String name,
        String email,
        String cpf,
        String phone
) {
        public UserResponseDto(Long id, String name, String email, String cpf, String phone) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.cpf = cpf;
                this.phone = phone;
        }
}
