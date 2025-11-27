package com.dev.dj.PlaceInTime.dtos;

import com.dev.dj.PlaceInTime.enums.PaymentStatus;
import com.dev.dj.PlaceInTime.enums.StatusBooking;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingDto(
        UUID id,
        @NotNull(message = "Slot cannot empty.")
        SlotDto slot,
        @NotNull(message = "Status cannot empty.")
        StatusBooking status,
        @NotNull(message = "CheckInAt cannot empty.")
        LocalDateTime checkInAt,
        @NotNull(message = "CheckOut cannot empty.")
        LocalDateTime checkOutAT,
        PaymentStatus paymentStatus

) {
}
