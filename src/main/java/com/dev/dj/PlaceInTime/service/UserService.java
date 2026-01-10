package com.dev.dj.PlaceInTime.service;

import com.dev.dj.PlaceInTime.dtos.UserCreateDTO;
import com.dev.dj.PlaceInTime.dtos.UserResponseDTO;
import com.dev.dj.PlaceInTime.entity.User;
import com.dev.dj.PlaceInTime.exception.DataConflictException;
import com.dev.dj.PlaceInTime.mapper.UserMapper;
import com.dev.dj.PlaceInTime.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    //CREATE
    public UserResponseDTO create(UserCreateDTO dto){
        if (userRepository.existsByEmail(dto.email()) || userRepository.existsByCpf(dto.cpf())){
            throw new DataConflictException("Data conflict"); //! Melhorar o Tratamento de Erro
        }

        User user = UserMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserMapper.toResponse(user);
    }
}