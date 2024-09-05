package com.example.CurdOfUsersWithSolid.repository;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDatabaseImpl implements Connection {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAllByActiveTrue()
                .stream()
                .map(e ->
                        new User (
                                e.getId(),
                                e.getName(),
                                e.getEmail(),
                                e.getPassword(),
                                e.getCpf(),
                                e.getPhone(),
                                e.getActive()
                        )
                ).toList();
    }

    @Override
    public User getOneUser(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

}
