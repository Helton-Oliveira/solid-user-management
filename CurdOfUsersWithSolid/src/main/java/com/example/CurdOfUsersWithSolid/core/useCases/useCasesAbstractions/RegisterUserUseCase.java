package com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;

public interface RegisterUserUseCase {
    UserDomain execute(String name, String email, String password, String cpf, String phone);
}
