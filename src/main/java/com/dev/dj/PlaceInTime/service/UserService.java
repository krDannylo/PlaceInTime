package com.dev.dj.PlaceInTime.service;

import com.dev.dj.PlaceInTime.dtos.UserDto;
import com.dev.dj.PlaceInTime.entity.User;
import com.dev.dj.PlaceInTime.exception.DataConflictException;
import com.dev.dj.PlaceInTime.repository.UserRepository;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        Optional<User> userModelOptional = userRepository.findById(id);
        if(userModelOptional.isEmpty()){
            throw new DataConflictException("Error: User not found");
        }
        return userModelOptional;
    }

    public User update(UserDto userDto,User user) {
        user.setName(userDto.name());
        user.setPhone(userDto.phone());
        user.setRole(userDto.role());

        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}