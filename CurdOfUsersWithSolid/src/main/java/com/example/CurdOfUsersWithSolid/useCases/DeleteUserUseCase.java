package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.repository.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCase {

    @Autowired
    private UserRepositoryService repositoryService;

    public void execute(Long id){
        var entity = repositoryService.getOneUser(id);
        entity.delete();
        repositoryService.saveUser(entity);
    }
}
