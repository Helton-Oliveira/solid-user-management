package com.example.CurdOfUsersWithSolid.useCases.factory;

import com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UseCaseFactoryImpl implements UseCaseFactory{
    private final RegisterUserUseCase registerUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetOneUserUseCase getOneUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @Autowired
    public UseCaseFactoryImpl(RegisterUserUseCase registerUserUseCase,
                              GetAllUsersUseCase getAllUsersUseCase,
                              GetOneUserUseCase getOneUserUseCase,
                              UpdateUserUseCase updateUserUseCase,
                              DeleteUserUseCase deleteUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getOneUserUseCase = getOneUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @Override
    public RegisterUserUseCase createUserUseCase() {
        return registerUserUseCase;
    }

    @Override
    public GetAllUsersUseCase createGetAllUsersUseCase() {
        return getAllUsersUseCase;
    }

    @Override
    public GetOneUserUseCase createGetOneUserUseCase() {
        return getOneUserUseCase;
    }

    @Override
    public UpdateUserUseCase createUpdateUserUseCase() {
        return updateUserUseCase;
    }

    @Override
    public DeleteUserUseCase createDeleteUserUseCase() {
        return deleteUserUseCase;
    }
}
