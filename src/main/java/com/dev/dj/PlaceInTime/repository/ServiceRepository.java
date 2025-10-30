package com.dev.dj.PlaceInTime.repository;

import com.dev.dj.PlaceInTime.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {

    Optional<Service> findByName(String name);

}
