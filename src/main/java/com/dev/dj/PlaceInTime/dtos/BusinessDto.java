package com.dev.dj.PlaceInTime.dtos;

import jakarta.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

public record BusinessDto(

        UUID id,
        @NotNull(message = "Owner cannot be empty.")
        UserReadDto owner,
        @NotNull(message = "Name cannot be empty.")
        String name,
        @NotNull(message = "Address cannot be empty.")
        String address,
        @NotNull(message = "TypeBusiness cannot be empty.")
        String typeBusiness,
        String description,
        String image,
        Set<ServiceDto> services
) {
}
