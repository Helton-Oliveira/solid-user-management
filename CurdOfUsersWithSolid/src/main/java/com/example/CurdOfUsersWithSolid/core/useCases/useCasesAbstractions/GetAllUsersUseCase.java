package com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.core.entity.User;

import java.util.List;

public interface GetAllUsersUseCase {
     List<User> execute();
}
