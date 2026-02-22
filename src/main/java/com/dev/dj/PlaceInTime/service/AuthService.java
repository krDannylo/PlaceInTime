package com.dev.dj.PlaceInTime.service;

import com.dev.dj.PlaceInTime.dtos.UserDto;
import com.dev.dj.PlaceInTime.entity.User;
import com.dev.dj.PlaceInTime.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authManager;


    private final JwtService jwtService;


    public AuthService(AuthenticationManager authManager, JwtService jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    public String login(UserDto dto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.email(), dto.password())
        );
        return jwtService.gerarToken(dto.email());
    }


}
