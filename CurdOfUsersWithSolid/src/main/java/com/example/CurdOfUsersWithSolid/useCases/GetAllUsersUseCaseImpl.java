package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.dtos.ResponseDto;
import com.example.CurdOfUsersWithSolid.repository.UserRepositoryService;
import com.example.CurdOfUsersWithSolid.repository.UserRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersUseCaseImpl implements UseCasesResponse{

    private final UserRepositoryService service ;

    @Autowired
    public GetAllUsersUseCaseImpl(UserRepositoryServiceImpl service) {
        this.service = service;
    }

    @Override
    public Page<ResponseDto> execute() {
        Pageable page = Pageable.ofSize(10);
        var responseList = service.getAllUsers();
        return new PageImpl<>(responseList, page, 10);
    }
}
