package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import com.example.CurdOfUsersWithSolid.repository.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private Connection connection;

    public User execute(String name, String email, String password, String cpf, String phone) {
        var entity = new User(name, email, password, cpf, phone);
        return connection.saveUser(entity);
    }
}
