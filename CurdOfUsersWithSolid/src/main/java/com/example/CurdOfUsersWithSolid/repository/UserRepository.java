package com.example.CurdOfUsersWithSolid.repository;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByActiveTrue();
}
