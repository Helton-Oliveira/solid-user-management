package com.example.CurdOfUsersWithSolid.repository;

import com.example.CurdOfUsersWithSolid.dtos.RequestDto;
import com.example.CurdOfUsersWithSolid.dtos.ResponseDto;
import com.example.CurdOfUsersWithSolid.entity.User;

import java.util.List;

public interface UserRepositoryService {

    public List<ResponseDto> getAllUsers();

    public ResponseDto saveUser(RequestDto user);

    public ResponseDto updateUser(RequestDto dto, User user);

}
