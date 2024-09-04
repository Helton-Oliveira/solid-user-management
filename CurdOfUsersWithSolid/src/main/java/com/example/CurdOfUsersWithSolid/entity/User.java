package com.example.CurdOfUsersWithSolid.entity;

import jakarta.persistence.*;
import lombok.*;

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

}


