package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import com.example.CurdOfUsersWithSolid.repository.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private  UserRepositoryService service;

    public User execute(String name, String email, String password, String cpf, String phone) {
        var entity = new User(name, email, password, cpf, phone);
        return service.saveUser(entity);
    }
}
