package com.example.CurdOfUsersWithSolid.core.useCases;

import com.example.CurdOfUsersWithSolid.adapters.encrypt.PasswordEncyption;
import com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions.RegisterUserUseCase;
import com.example.CurdOfUsersWithSolid.core.entity.User;
import com.example.CurdOfUsersWithSolid.core.repository.Connection;
import com.example.CurdOfUsersWithSolid.core.useCases.validations.validatingUserRegistration.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    @Autowired
    private Connection connection;

    @Autowired
    private PasswordEncyption encyption;

    @Autowired
    private Validation validation;

    @Override
    public User execute(String name, String email, String password, String cpf, String phone) {
        validation.validate(cpf);
        var entity = new User(name, email, encyption.encrypt(password), cpf, phone);
        return connection.saveUser(entity);
    }
}

