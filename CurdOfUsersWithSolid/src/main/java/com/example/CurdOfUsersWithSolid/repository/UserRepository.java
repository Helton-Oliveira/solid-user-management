package com.example.CurdOfUsersWithSolid.repository;

import com.example.CurdOfUsersWithSolid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
