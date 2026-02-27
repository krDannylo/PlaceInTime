package com.dev.dj.PlaceInTime.controller;

import com.dev.dj.PlaceInTime.dtos.UserDto;
import com.dev.dj.PlaceInTime.entity.User;
import com.dev.dj.PlaceInTime.service.AuthService;
import com.dev.dj.PlaceInTime.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody @JsonView(UserDto.UserView.LoginRequest.class)
            @Validated(UserDto.UserView.LoginRequest.class) UserDto userDto) {

        String token = authService.login(userDto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody @Validated(UserDto.UserView.RegistrationPost.class)
                                       @JsonView(UserDto.UserView.RegistrationPost.class) UserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }
}
