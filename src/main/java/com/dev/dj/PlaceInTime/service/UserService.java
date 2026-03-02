package com.dev.dj.PlaceInTime.service;

import com.dev.dj.PlaceInTime.dtos.UserCreateDTO;
import com.dev.dj.PlaceInTime.dtos.UserResponseDTO;
import com.dev.dj.PlaceInTime.entity.User;
import com.dev.dj.PlaceInTime.exception.DataConflictException;
import com.dev.dj.PlaceInTime.mapper.UserMapper;
import com.dev.dj.PlaceInTime.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public UserResponseDTO create(UserCreateDTO dto){
        if (userRepository.existsByEmail(dto.email()) || userRepository.existsByCpf(dto.cpf())  ||  userRepository.existsByPhone(dto.phone())){
            throw new DataConflictException("Data conflict");
        }

        User user = UserMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserMapper.toResponse(user);
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    public Optional<UserResponseDTO> findById(UUID id) {
        return userRepository.findById(id).map(UserMapper::toResponse);
    }

    public Optional<UserResponseDTO> update(UUID id, UserCreateDTO dto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }

        if (userRepository.existsByEmailAndIdNot(dto.email(), id)
                || userRepository.existsByCpfAndIdNot(dto.cpf(), id)
                || userRepository.existsByPhoneAndIdNot(dto.phone(), id)) {
            throw new DataConflictException("Data conflict");
        }

        User user = optionalUser.get();
        user.setName(dto.name());
        user.setCpf(dto.cpf());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setPhone(dto.phone());
        user.setRole(dto.role());

        userRepository.save(user);
        return Optional.of(UserMapper.toResponse(user));
    }

    public boolean delete(UUID id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}