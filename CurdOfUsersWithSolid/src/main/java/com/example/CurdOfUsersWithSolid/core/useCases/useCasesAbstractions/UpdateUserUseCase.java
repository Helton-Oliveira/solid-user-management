package com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.core.entity.User;

public interface UpdateUserUseCase {
    User execute(Long id, String firsCamp, String secondCamp);
}
