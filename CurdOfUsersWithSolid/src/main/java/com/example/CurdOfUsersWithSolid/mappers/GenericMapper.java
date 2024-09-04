package com.example.CurdOfUsersWithSolid.mappers;

import com.example.CurdOfUsersWithSolid.dtos.RequestDto;

public interface GenericMapper<T, R> {
     T toEntity(RequestDto dto);

     R toDto(T entity);
}
