package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import com.example.CurdOfUsersWithSolid.repository.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOneUserUseCase {

    @Autowired
    private UserRepositoryService repositoryService;

    public User execute(Long id) {
        return repositoryService.getOneUser(id);
    }
}
