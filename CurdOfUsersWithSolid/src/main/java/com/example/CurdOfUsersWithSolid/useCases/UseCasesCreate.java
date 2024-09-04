package com.example.CurdOfUsersWithSolid.useCases;

import com.example.CurdOfUsersWithSolid.dtos.RequestDto;

public interface UseCasesCreate {
    <T> T execute(RequestDto dto);
}
