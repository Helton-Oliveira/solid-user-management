package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.dtos.RequestDto;
import com.example.CurdOfUsersWithSolid.dtos.ResponseDto;
import com.example.CurdOfUsersWithSolid.repository.UserRepositoryService;
import com.example.CurdOfUsersWithSolid.repository.UserRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImpl implements UseCasesCreate {

    private final UserRepositoryService service;

    @Autowired
    public CreateUserUseCaseImpl(UserRepositoryServiceImpl service) {
        this.service = service;
    }

    @Override
    public ResponseDto execute(RequestDto dto) {
        return service.saveUser(dto);
    }
}
