package com.example.CurdOfUsersWithSolid.core.useCases;

import com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions.GetOneUserUseCase;
import com.example.CurdOfUsersWithSolid.core.entity.User;
import com.example.CurdOfUsersWithSolid.core.repository.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOneUserUseCaseImpl implements GetOneUserUseCase {

    @Autowired
    private Connection connection;

    @Override
    public User execute(Long id) {
        return connection.getOneUser(id);
    }
}
