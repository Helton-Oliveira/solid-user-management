package com.example.CurdOfUsersWithSolid.core.useCases;

import com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions.UpdateUserUseCase;
import com.example.CurdOfUsersWithSolid.core.domain.UserDomain;
import com.example.CurdOfUsersWithSolid.core.repository.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    @Autowired
    private Connection connection;

    @Override
    public UserDomain execute(Long id, String firsCamp, String secondCamp) {
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
