package com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;

public interface GetOneUserUseCase {
     UserDomain execute(Long id);
}
