package com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.core.entity.User;

public interface GetOneUserUseCase {
     User execute(Long id);
}
