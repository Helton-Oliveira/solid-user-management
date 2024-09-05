package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import com.example.CurdOfUsersWithSolid.repository.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOneUserUseCase {

    @Autowired
    private Connection connection;

    public User execute(Long id) {
        return connection.getOneUser(id);
    }
}
