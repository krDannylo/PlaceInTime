package com.dev.dj.PlaceInTime.dtos;

import jakarta.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

public record ServiceDto(
        UUID id,

        String description,
        @NotNull(message = "Name cannot be empty.")
        String name,
        @NotNull(message = "DurationMinutes cannot be empty.")
        String durationMinutes,
        @NotNull(message = "Price cannot be empty.")
        String price,
        @NotNull(message = "Active cannot be empty.")
        boolean active,
        @NotNull(message = "Business cannot be empty.")
        BusinessDto business,
        Set<SlotDto> slots
) {
}
