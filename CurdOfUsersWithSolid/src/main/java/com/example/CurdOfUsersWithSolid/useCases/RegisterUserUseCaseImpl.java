package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import com.example.CurdOfUsersWithSolid.repository.Connection;
import com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions.RegisterUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    @Autowired
    private Connection connection;

    @Override
    public User execute(String name, String email, String password, String cpf, String phone) {
        var entity = new User(name, email, password, cpf, phone);
        return connection.saveUser(entity);
    }
}

