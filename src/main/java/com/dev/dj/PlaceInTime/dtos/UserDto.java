package com.dev.dj.PlaceInTime.dtos;

import com.dev.dj.PlaceInTime.enums.Role;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(
        @JsonView(UserResponseDTO.UserView.RegistrationPost.class)
        @NotBlank(message = "Name cannot be empty.",groups = UserDto.UserView.RegistrationPost.class)
        String name,
        @JsonView(UserDto.UserView.RegistrationPost.class)
        @NotBlank(message = "CPF cannot be empty.",groups = UserDto.UserView.RegistrationPost.class)
        @Size(min = 11, max = 11, message = "CPF must have exactly 11 digits.",groups = UserDto.UserView.RegistrationPost.class)
        String cpf,
        @JsonView({UserDto.UserView.RegistrationPost.class, UserDto.UserView.LoginRequest.class})
        @NotBlank(message = "Email cannot be empty.",groups = {UserDto.UserView.RegistrationPost.class, UserDto.UserView.LoginRequest.class})
        String email,

        @NotBlank(message = "Phone cannot be empty.",groups = UserDto.UserView.RegistrationPost.class)
        @Size(min = 11, max = 11, message = "Phone must have exactly 11 digits.",groups = UserDto.UserView.RegistrationPost.class)
        String phone,
        @JsonView(UserDto.UserView.RegistrationPost.class)
        @NotNull(message = "Role cannot be null.",groups = UserDto.UserView.RegistrationPost.class)
        Role role,
        @NotBlank(groups = {UserDto.UserView.RegistrationPost.class, UserDto.UserView.PasswordPut.class, UserDto.UserView.LoginRequest.class},message = "Password is mandatory")
        @Size(min = 6,max = 20,message = "Size must be between 6 and 20",groups = {UserDto.UserView.RegistrationPost.class, UserDto.UserView.PasswordPut.class, UserDto.UserView.LoginRequest.class})
        @JsonView({UserDto.UserView.RegistrationPost.class, UserDto.UserView.PasswordPut.class, UserDto.UserView.LoginRequest.class})
        String password,

        @NotBlank(message = "Old Password is mandatory",groups = UserDto.UserView.PasswordPut.class)
        @Size(min = 6,max = 20,message = "Size must be between 6 and 20",groups = UserDto.UserView.PasswordPut.class)
        @JsonView({UserDto.UserView.PasswordPut.class})
        String oldPassword
) {
    public interface UserView{
        interface RegistrationPost{}
        interface PasswordPut{}
        interface LoginRequest{}
    }
}
