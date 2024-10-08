package com.example.CurdOfUsersWithSolid.core.useCases;

import com.example.CurdOfUsersWithSolid.core.repository.Connection;
import com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions.DeleteUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    @Autowired
    private Connection connection;

    @Override
    public void execute(Long id){
        var entity = connection.getOneUser(id);
        entity.delete();
        connection.saveUser(entity);
    }
}
