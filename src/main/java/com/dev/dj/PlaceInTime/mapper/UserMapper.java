package com.dev.dj.PlaceInTime.mapper;

import com.dev.dj.PlaceInTime.dtos.UserCreateDTO;
import com.dev.dj.PlaceInTime.dtos.UserResponseDTO;
import com.dev.dj.PlaceInTime.entity.User;

public class UserMapper {
    
    public static User toEntity(UserCreateDTO dto){
        User user = new User();
        user.setName(dto.name());
        user.setCpf(dto.cpf());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setPhone(dto.phone());
        user.setRole(dto.role());
        return user;
    }

    public static UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getName(),
            user.getCpf(),
            user.getEmail(),
            user.getPhone(),
            user.getRole()
        );
    }
}
