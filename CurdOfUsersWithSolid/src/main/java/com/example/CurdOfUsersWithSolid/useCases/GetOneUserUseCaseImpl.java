package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import com.example.CurdOfUsersWithSolid.repository.Connection;
import com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions.GetOneUserUseCase;
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
