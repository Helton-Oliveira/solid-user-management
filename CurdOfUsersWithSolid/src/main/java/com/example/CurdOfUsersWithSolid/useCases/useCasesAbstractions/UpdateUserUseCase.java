package com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.domain.entity.User;

public interface UpdateUserUseCase {
    User execute(Long id, String firsCamp, String secondCamp);
}
