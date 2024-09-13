package com.example.CurdOfUsersWithSolid.adapters.outputDtoAdapter;

import com.example.CurdOfUsersWithSolid.dtos.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OutPutDtoImpl implements OutputDto{

    @Override
    public UserResponseDto createOutputDto(Long id, String name, String email, String cpf, String phone) {
        return new UserResponseDto(id, name, email, cpf, phone);
    }
}
