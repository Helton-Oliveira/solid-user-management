package com.example.CurdOfUsersWithSolid.mappers;

public interface GenericMapper <T, R, M>{
    R toDto(T entity);
    T toEntity(M Dto);
}
