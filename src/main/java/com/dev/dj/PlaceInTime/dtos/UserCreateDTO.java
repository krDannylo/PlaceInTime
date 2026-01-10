package com.dev.dj.PlaceInTime.dtos;

import com.dev.dj.PlaceInTime.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateDTO(

        @NotBlank(message = "Name cannot be empty.")
        String name,

        @NotBlank(message = "CPF cannot be empty.")
        @Size(min = 11, max = 11, message = "CPF must have exactly 11 digits.")
        String cpf,

        @NotBlank(message = "Email cannot be empty.")
        String email,

        @NotBlank(message = "Password cannot be empty.")
        String password,

        @NotBlank(message = "Phone cannot be empty.")
        @Size(min = 11, max = 11, message = "Phone must have exactly 11 digits.")
        String phone,

        @NotNull(message = "Role cannot be null.")
        Role role
) {
}