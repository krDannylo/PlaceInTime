package com.dev.dj.PlaceInTime.dtos;

import com.dev.dj.PlaceInTime.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.UUID;

public record UserCreateDto(
        UUID id,
        String name,
        @NotNull(message = "Email cannot be empty.")
        String email,
        @NotNull (message = "The cpf cannot be empty.")
        @Size(min = 11, max = 11, message = "The cpf must have exactly 11 digits.")
        String cpf,
        @NotNull (message = "The phone cannot be empty.")
        @Size(min = 11, max = 11, message = "The phone number must have exactly 11 digits.")
        String phone,
        @NotNull(message = "Email cannot be empty.")
        String password,
        @NotNull(message = "Role cannot be empty.")
        Role role,

        Set<BusinessDto> business
) {
}
