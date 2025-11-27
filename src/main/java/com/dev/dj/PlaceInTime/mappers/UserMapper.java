package com.dev.dj.PlaceInTime.mappers;

import com.dev.dj.PlaceInTime.dtos.UserCreateDto;
import com.dev.dj.PlaceInTime.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring", uses = {BusinessMapper.class})
public abstract class UserMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    public abstract UserCreateDto toDto(User entity);

    // Ao salvar (DTO -> Entity), criptografamos a senha
    @Mapping(target = "password", qualifiedByName = "encodePassword")
    public abstract User toEntity(UserCreateDto dto);

    @Named("encodePassword")
    protected String encodePassword(String rawPassword) {
        if (rawPassword == null) return null;
        return passwordEncoder.encode(rawPassword);
    }
}