package com.dev.dj.PlaceInTime.controller;

import com.dev.dj.PlaceInTime.dtos.UserCreateDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.environment}")
    private String environment;

    @Value("${server.version}")
    private String version;

    @GetMapping
    public ResponseEntity<List<UserCreateDto>> findByAllUsers(HttpServletRequest request) {


    }

}
