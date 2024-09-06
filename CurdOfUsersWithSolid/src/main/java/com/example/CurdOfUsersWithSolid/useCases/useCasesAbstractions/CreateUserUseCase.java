package com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.domain.entity.User;

public interface CreateUserUseCase {
     User execute(String name, String email, String password, String cpf, String phone);
}
