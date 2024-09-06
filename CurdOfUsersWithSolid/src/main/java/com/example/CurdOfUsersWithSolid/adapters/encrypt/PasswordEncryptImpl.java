package com.example.CurdOfUsersWithSolid.adapters.encrypt;

import io.github.cdimascio.dotenv.Dotenv;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Component
public class PasswordEncryptImpl implements PasswordEncyption{
    private static final Path path = Paths.get("CurdOfUsersWithSolid", ".env");
    private static final Dotenv dotEnv = Dotenv.configure()
            .directory(String.valueOf(path.toAbsolutePath()))
            .load();

    @Override
    public String encrypt(String password) {
        int saltRounds = Integer.parseInt(Objects.requireNonNull(dotEnv.get("SALT")));
        String salt = BCrypt.gensalt(saltRounds);
        return BCrypt.hashpw(password, salt);
    }

}
