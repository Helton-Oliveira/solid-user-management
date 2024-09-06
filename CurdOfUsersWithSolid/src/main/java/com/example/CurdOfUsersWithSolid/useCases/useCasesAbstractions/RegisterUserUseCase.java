package com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.domain.entity.User;

public interface RegisterUserUseCase {
    User execute(String name, String email, String password, String cpf, String phone);
}
