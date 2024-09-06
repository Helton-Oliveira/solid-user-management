package com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.core.entity.User;

public interface RegisterUserUseCase {
    User execute(String name, String email, String password, String cpf, String phone);
}
