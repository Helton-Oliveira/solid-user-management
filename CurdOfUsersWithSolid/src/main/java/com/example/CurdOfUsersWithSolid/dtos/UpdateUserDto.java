package com.example.CurdOfUsersWithSolid.dtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserDto(
        @NotBlank
        String email,
        String password
) { }
