package com.example.CurdOfUsersWithSolid.adapters.outputDtoAdapter;

import com.example.CurdOfUsersWithSolid.dtos.UserResponseDto;

public interface OutputDto {
    UserResponseDto createOutputDto(Long id, String name, String email, String cpf, String phone);
}
