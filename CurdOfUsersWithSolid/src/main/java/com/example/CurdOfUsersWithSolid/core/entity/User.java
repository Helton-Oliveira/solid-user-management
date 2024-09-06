package com.example.CurdOfUsersWithSolid.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "phone")
    private String phone;

    @Column(name = "active")
    private Boolean active = true;

    public User(String name, String email, String password, String cpf, String phone) {
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

    public User create(String name, String email, String password, String cpf, String phone) {
        this.setId(this.getId());
        return new User(name, email, password, cpf, phone);
    }

    public void delete() {
        this.setActive(false);
    }

    public Long loadId() {
        return this.getId();
    }
}


