package com.example.CurdOfUsersWithSolid.core.entity.entityAbstraction;

import java.util.List;
import java.util.Map;

public interface IEntity {

    IEntity create(String name, String email, String password, String cpf, String phone);
    List getInstance(Long id, String name, String email, String password, String cpf, String phone, Boolean active);
    void updateInfo(Map<String, String> dat);
    void delete();
    Long loadId();
}
