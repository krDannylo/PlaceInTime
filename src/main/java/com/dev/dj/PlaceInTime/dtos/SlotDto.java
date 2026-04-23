package com.dev.dj.PlaceInTime.dtos;

import com.dev.dj.PlaceInTime.enums.StatusSlot;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record SlotDto(
        UUID id,
        @NotNull(message = "Service cannot empty.")
        ServiceDto service,
        @NotNull(message = "StartTime cannot empty.")
        LocalDateTime startTime,
        @NotNull(message = "EndTime cannot empty.")
        LocalDateTime endTime,
        @NotNull(message = "Status cannot empty.")
        StatusSlot status,
        @NotNull(message = "Booking cannot empty.")
        BookingDto booking
) {
}
