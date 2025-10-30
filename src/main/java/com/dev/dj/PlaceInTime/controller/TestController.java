package com.dev.dj.PlaceInTime.controller;

import com.dev.dj.PlaceInTime.entity.Test;
import com.dev.dj.PlaceInTime.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tests")
public class TestController {

  @Autowired
  private TestRepository testRepository;

  @GetMapping
  public ResponseEntity<List<Test>> getAll() {
    List<Test> list = testRepository.findAll();
    return ResponseEntity.ok(list);
  }

  @PostMapping
  public ResponseEntity<Test> create(@RequestBody Test body) {
    Test saved = testRepository.save(body);
    return ResponseEntity.ok(saved);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Test> getById(@PathVariable Long id) {
    Optional<Test> entity = testRepository.findById(id);
    return entity.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/search")
  public ResponseEntity<List<Test>> searchByName(@RequestParam("name") String name) {
    List<Test> list = testRepository.findByNameContainingIgnoreCase(name);
    return ResponseEntity.ok(list);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Test> update(@PathVariable Long id, @RequestBody Test body) {
    return testRepository.findById(id)
        .map(existing -> {
          existing.setName(body.getName());
          existing.setDescription(body.getDescription());
          Test saved = testRepository.save(existing);
          return ResponseEntity.ok(saved);
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (testRepository.existsById(id)) {
      testRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
