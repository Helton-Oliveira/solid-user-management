package com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;

import java.util.List;

public interface GetAllUsersUseCase {
     List<UserDomain> execute();
}
