package com.example.CurdOfUsersWithSolid.core.useCases;

import com.example.CurdOfUsersWithSolid.core.entity.User;
import com.example.CurdOfUsersWithSolid.core.repository.Connection;
import com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions.GetAllUsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

    @Autowired
    private Connection connection;

    @Override
    public List<User> execute() {
        return connection.getAllUsers();
    }
}
