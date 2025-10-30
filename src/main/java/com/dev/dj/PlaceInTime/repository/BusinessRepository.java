package com.dev.dj.PlaceInTime.repository;

import com.dev.dj.PlaceInTime.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BusinessRepository extends JpaRepository<Business, UUID> {
    Optional<Business> findByName(String name);
    
    Optional<Business> findByAddress(String address);

    Optional<Business> findByTypeBusiness(String typeBusiness);
    
}
