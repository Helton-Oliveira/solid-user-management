package com.example.CurdOfUsersWithSolid.core.repository;

import com.example.CurdOfUsersWithSolid.adapters.mapper.MapperAdapater;
import com.example.CurdOfUsersWithSolid.adapters.repository.UserEntity;
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
    private MapperAdapater mapper;

    @Override
    public List<UserDomain> getAllUsers() {
        return repository.findAllByActiveTrue()
                .stream()
                .map(e -> {
                    var entity = mapper.toDomain(e.getName(), e.getEmail(), e.getPassword(), e.getCpf(), e.getPhone());
                    entity.setId(e.getId());
                    return entity;
                }).toList();
    }

    @Override
    public UserDomain getOneUser(Long id) {
        var entity = repository.findById(id).orElseThrow();
        var domain = mapper.toDomain(entity.getName(), entity.getEmail(), entity.getPassword(), entity.getCpf(), entity.getPhone());
        domain.setId(entity.getId());
        return domain;
    }

    @Override
    public UserDomain saveUser(UserDomain user) {
        var entity = mapper.toEntity(user.getName(), user.getEmail(), user.getPassword(), user.getCpf(), user.getPhone());
        repository.save(entity);
        var domain = mapper.toDomain(entity.getName(), entity.getEmail(), entity.getPassword(), entity.getCpf(), entity.getPhone());
        domain.setId(entity.getId());
        return domain;
    }

}
