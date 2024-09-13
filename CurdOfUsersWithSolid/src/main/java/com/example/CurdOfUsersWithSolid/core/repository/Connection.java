package com.example.CurdOfUsersWithSolid.core.repository;

import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;

import java.util.List;

public interface Connection {

    List<UserDomain> getAllUsers();

    UserDomain getOneUser(Long id);

    UserDomain saveUser(UserDomain user);

}
