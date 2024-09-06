package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import com.example.CurdOfUsersWithSolid.repository.Connection;
import com.example.CurdOfUsersWithSolid.useCases.useCasesAbstractions.GetAllUsersUseCase;
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
