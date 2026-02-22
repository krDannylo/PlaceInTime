package com.dev.dj.PlaceInTime.controller;

import com.dev.dj.PlaceInTime.dtos.UserDto;
import com.dev.dj.PlaceInTime.entity.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.dj.PlaceInTime.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Validated(UserDto.UserView.RegistrationPost.class)
                                           @JsonView(UserDto.UserView.RegistrationPost.class) UserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }
}