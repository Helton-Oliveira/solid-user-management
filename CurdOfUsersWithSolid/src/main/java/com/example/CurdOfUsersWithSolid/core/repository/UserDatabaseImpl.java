package com.example.CurdOfUsersWithSolid.core.repository;

import com.example.CurdOfUsersWithSolid.adapters.mapper.UserMapper;
import com.example.CurdOfUsersWithSolid.adapters.repository.UserRepository;
import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDatabaseImpl implements Connection {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDomain> getAllUsers() {
        return repository.findAllByActiveTrue()
                .stream()
                .map(e ->  mapper.toDomain(e.getId(), e.getName(), e.getEmail(), e.getPassword(), e.getCpf(), e.getPhone()))
                .toList();
    }

    @Override
    public UserDomain getOneUser(Long id) {
        var entity = repository.findById(id).orElseThrow();
        return mapper.toDomain(entity.getId() ,entity.getName(), entity.getEmail(), entity.getPassword(), entity.getCpf(), entity.getPhone());
    }

    @Override
    public UserDomain saveUser(UserDomain user) {
        var entity = mapper.toEntity(user.getName(), user.getEmail(), user.getPassword(), user.getCpf(), user.getPhone());
        repository.save(entity);
        return mapper.toDomain(entity.getId(), entity.getName(), entity.getEmail(), entity.getPassword(), entity.getCpf(), entity.getPhone());
    }

}
