package com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;

public interface UpdateUserUseCase {
    UserDomain execute(Long id, String firsCamp, String secondCamp);
}
