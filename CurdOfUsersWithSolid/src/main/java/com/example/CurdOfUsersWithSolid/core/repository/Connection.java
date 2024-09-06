package com.example.CurdOfUsersWithSolid.core.repository;

import com.example.CurdOfUsersWithSolid.core.entity.User;

import java.util.List;

public interface Connection {

    List<User> getAllUsers();

    User getOneUser(Long id);

    User saveUser(User user);

}
