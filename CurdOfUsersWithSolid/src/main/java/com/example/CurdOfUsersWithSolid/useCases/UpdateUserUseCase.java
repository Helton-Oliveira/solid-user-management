package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.domain.entity.User;
import com.example.CurdOfUsersWithSolid.repository.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateUserUseCase {

    @Autowired
    private Connection connection;

    public User execute(Long id, String firsCamp, String secondCamp) {
        var entityToUpdate = connection.getOneUser(id);

        Map<String, String> map = new HashMap<String, String>();

        if(firsCamp != null) {
            map.put("email", firsCamp);
        }

        if(secondCamp != null) {
            map.put("password", secondCamp);
        }

        entityToUpdate.updateInfo(map);
        return connection.saveUser(entityToUpdate);
    }
}
