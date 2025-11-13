package com.dev.dj.PlaceInTime.repository;

import com.dev.dj.PlaceInTime.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByName(String name);

    Optional<User> findByCpf(String cpf);

    Optional<User> findByEmail(String email);

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

}
