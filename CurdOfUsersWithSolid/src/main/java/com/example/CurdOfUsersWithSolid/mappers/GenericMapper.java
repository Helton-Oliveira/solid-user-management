package com.example.CurdOfUsersWithSolid.mappers;

import com.example.CurdOfUsersWithSolid.dtos.RequestDto;
import com.example.CurdOfUsersWithSolid.dtos.ResponseDto;

public interface GenericMapper<T> {
     T toEntity(RequestDto dto);

     ResponseDto toDto(T entity);
}
