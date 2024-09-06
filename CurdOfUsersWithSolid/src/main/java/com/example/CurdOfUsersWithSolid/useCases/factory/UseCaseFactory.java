package com.example.CurdOfUsersWithSolid.useCases.factory;

import com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions.*;

public interface UseCaseFactory {
   RegisterUserUseCase createUserUseCase();
   GetAllUsersUseCase createGetAllUsersUseCase();
   GetOneUserUseCase createGetOneUserUseCase();
   UpdateUserUseCase createUpdateUserUseCase();
   DeleteUserUseCase createDeleteUserUseCase();
}
