package com.dev.dj.PlaceInTime.repository;

import com.dev.dj.PlaceInTime.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SlotRepository extends JpaRepository<Slot, UUID> {
}
