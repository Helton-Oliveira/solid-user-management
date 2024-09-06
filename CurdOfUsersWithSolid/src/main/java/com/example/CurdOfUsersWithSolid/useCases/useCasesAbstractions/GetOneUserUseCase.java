package com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.domain.entity.User;

public interface GetOneUserUseCase {
     User execute(Long id);
}
