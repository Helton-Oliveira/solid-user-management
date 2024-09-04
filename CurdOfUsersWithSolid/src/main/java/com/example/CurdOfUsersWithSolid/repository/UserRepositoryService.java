package com.example.CurdOfUsersWithSolid.repository;

import com.example.CurdOfUsersWithSolid.domain.entity.User;

import java.util.List;

public interface UserRepositoryService {

    List<User> getAllUsers();

    User getOneUser(Long id);

    User saveUser(User user);

}
