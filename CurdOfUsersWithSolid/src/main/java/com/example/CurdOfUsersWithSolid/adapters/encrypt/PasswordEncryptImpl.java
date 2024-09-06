package com.example.CurdOfUsersWithSolid.adapters.encrypt;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptImpl implements PasswordEncyption{

    @Override
    public String encrypt(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

}
