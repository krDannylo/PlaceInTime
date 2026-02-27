package com.dev.dj.PlaceInTime.service;

import com.dev.dj.PlaceInTime.dtos.UserDto;
import com.dev.dj.PlaceInTime.entity.User;
import com.dev.dj.PlaceInTime.exception.DataConflictException;
import com.dev.dj.PlaceInTime.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(UserDto dto){
        if (userRepository.existsByEmail(dto.email()) || userRepository.existsByCpf(dto.cpf())  ||  userRepository.existsByPhone(dto.phone())){
            throw new DataConflictException("Data conflict");
        }

        var user = new User();
        BeanUtils.copyProperties(dto,user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }
}