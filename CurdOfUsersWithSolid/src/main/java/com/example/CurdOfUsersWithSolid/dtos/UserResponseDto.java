package com.example.CurdOfUsersWithSolid.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserResponseDto(
        Long id,
        String name,
        String email,
        @JsonIgnore
        String password,
        String cpf,
        String phone
) implements ResponseDto{
}
