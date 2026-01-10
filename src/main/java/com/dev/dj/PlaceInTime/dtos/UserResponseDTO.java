package com.dev.dj.PlaceInTime.dtos;

import java.util.UUID;
import com.dev.dj.PlaceInTime.enums.Role;

public record UserResponseDTO(
    UUID id, 
    String name, 
    String cpf, 
    String email, 
    String phone, 
    Role role
) {}