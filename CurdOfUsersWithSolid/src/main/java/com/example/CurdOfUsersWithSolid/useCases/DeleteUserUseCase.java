package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.repository.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCase {

    @Autowired
    private Connection connection;

    public void execute(Long id){
        var entity = connection.getOneUser(id);
        entity.delete();
        connection.saveUser(entity);
    }
}
