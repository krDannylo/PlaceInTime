package com.dev.dj.PlaceInTime.dtos;

import com.dev.dj.PlaceInTime.enums.Role;
import java.util.Set;
import java.util.UUID;

public record UserReadDto(
        UUID id,
        String name,
        String email,
        String cpf,
        String phone,
        Role role,
        Set<BusinessDto> business
) {}