package com.dev.dj.PlaceInTime.controller;

import com.dev.dj.PlaceInTime.dtos.UserDto;
import com.dev.dj.PlaceInTime.entity.User;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dev.dj.PlaceInTime.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
                                                  @RequestBody @Validated(UserDto.UserView.UpdateRequest.class)
                                                  @JsonView(UserDto.UserView.UpdateRequest.class) UserDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(dto,userService.findById(id).get()));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        userService.delete(userService.findById(id).get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }
}