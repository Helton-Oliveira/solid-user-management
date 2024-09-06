package com.example.CurdOfUsersWithSolid.factory;

import com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions.*;

public interface UseCaseFactory {
   RegisterUserUseCase createUserUseCase();
   GetAllUsersUseCase createGetAllUsersUseCase();
   GetOneUserUseCase createGetOneUserUseCase();
   UpdateUserUseCase createUpdateUserUseCase();
   DeleteUserUseCase createDeleteUserUseCase();
}
