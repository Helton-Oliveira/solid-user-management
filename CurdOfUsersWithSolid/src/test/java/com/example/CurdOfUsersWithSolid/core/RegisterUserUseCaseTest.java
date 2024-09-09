package com.example.CurdOfUsersWithSolid.core;

import com.example.CurdOfUsersWithSolid.adapters.encrypt.PasswordEncryptImpl;
import com.example.CurdOfUsersWithSolid.adapters.encrypt.PasswordEncyption;
import com.example.CurdOfUsersWithSolid.adapters.exceptions.CustomValidationException;
import com.example.CurdOfUsersWithSolid.core.entity.User;
import com.example.CurdOfUsersWithSolid.core.useCases.validations.validatingUserRegistration.ValidateCpf;
import com.example.CurdOfUsersWithSolid.core.useCases.validations.validatingUserRegistration.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegisterUserUseCaseTest {

    private Validation validation;
    private PasswordEncyption encryption;

    @BeforeEach
    void setUp() {
        validation = new ValidateCpf();
        encryption = new PasswordEncryptImpl();
    }

    @Test
    @DisplayName("Should return error if CPF number is invalid")
    void validNumber() {
        var user = new User(1L, "George Cunha", "senha123", "george.cunha@example.com", "21309498098", "12345678", true);

        CustomValidationException exception = assertThrows(CustomValidationException.class, () -> {
            validation.validate(user.getCpf());
        });

        assertThat(exception.getMessage()).isEqualTo("Error! CPF is not valid.");
    }

    @Test
    @DisplayName("must encrypt the password")
    void validateEncryption() {
        var user = new User(1L, "Flavio Delvalle", "senha123", "flavio.delvalle@example.com", "17958851065", "12345678", true);

        var pass = encryption.encrypt(user.getPassword());

       assertThat(BCrypt.checkpw(user.getPassword(), pass)).isTrue();
    }
}
