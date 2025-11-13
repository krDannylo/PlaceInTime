package com.dev.dj.PlaceInTime.repository;

import com.dev.dj.PlaceInTime.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
