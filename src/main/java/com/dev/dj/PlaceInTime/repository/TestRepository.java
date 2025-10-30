package com.dev.dj.PlaceInTime.repository;

import com.dev.dj.PlaceInTime.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
  List<Test> findByNameContainingIgnoreCase(String name);
}
