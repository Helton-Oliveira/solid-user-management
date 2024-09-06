package com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions;

import com.example.CurdOfUsersWithSolid.domain.entity.User;

import java.util.List;

public interface GetAllUsersUseCase {
     List<User> execute();
}
