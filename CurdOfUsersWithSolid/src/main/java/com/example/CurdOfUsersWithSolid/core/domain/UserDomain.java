package com.example.CurdOfUsersWithSolid.core.domain;

import lombok.Data;
import lombok.Getter;

import java.util.Map;
@Data
public class UserDomain {

    private final String name;
    private final String cpf;
    private final String phone;
    private  String email;
    private  String password;
    private  Boolean active;
    private Long id;

    public UserDomain(Long id, String name, String email, String password, String cpf, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.active = true;
    }

    public void updateInfo(Map<String, String> data) {
        if (data.containsKey("email")) {
            this.setEmail(data.get("email"));
        }

        if (data.containsKey("password")) {
            this.setPassword(data.get("password"));
        }
    }

    public void delete() {
        this.setActive(false);
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setActive(Boolean active) {
        this.active = active;
    }


}


