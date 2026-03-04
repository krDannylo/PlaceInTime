package com.dev.dj.PlaceInTime.dtos;

import com.dev.dj.PlaceInTime.enums.Role;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(
        @JsonView({ UserView.RegistrationPost.class, UserView.UpdateRequest.class})
        @NotBlank(message = "Name cannot be empty.",groups = UserView.RegistrationPost.class)
        String name,
        @JsonView(UserView.RegistrationPost.class)
        @NotBlank(message = "CPF cannot be empty.",groups = UserView.RegistrationPost.class)
        @Size(min = 11, max = 11, message = "CPF must have exactly 11 digits.",groups = UserView.RegistrationPost.class)
        String cpf,
        @JsonView({UserView.RegistrationPost.class, UserView.LoginRequest.class})
        @Email(message = "Email must be in the expected format",groups = UserView.RegistrationPost.class)
        @NotBlank(message = "Email cannot be empty.",groups = {UserView.RegistrationPost.class, UserView.LoginRequest.class})
        String email,

        @JsonView({UserView.RegistrationPost.class, UserView.UpdateRequest.class})
        @NotBlank(message = "Phone cannot be empty.",groups = {UserView.RegistrationPost.class,UserView.UpdateRequest.class})
        @Size(min = 11, max = 11, message = "Phone must have exactly 11 digits.",groups = UserView.RegistrationPost.class)
        String phone,
        @JsonView({UserView.RegistrationPost.class, UserView.UpdateRequest.class})
        @NotNull(message = "Role cannot be null.",groups = {UserView.RegistrationPost.class, UserView.UpdateRequest.class})
        Role role,
        @NotBlank(groups = {UserView.RegistrationPost.class, UserView.PasswordPut.class, UserView.LoginRequest.class},message = "Password is mandatory")
        @Size(min = 6,max = 20,message = "Size must be between 6 and 20",groups = {UserView.RegistrationPost.class, UserView.PasswordPut.class, UserView.LoginRequest.class})
        @JsonView({UserView.RegistrationPost.class, UserView.PasswordPut.class, UserView.LoginRequest.class})
        String password,

        @NotBlank(message = "Old Password is mandatory",groups = UserView.PasswordPut.class)
        @Size(min = 6,max = 20,message = "Size must be between 6 and 20",groups = UserView.PasswordPut.class)
        @JsonView({UserView.PasswordPut.class})
        String oldPassword
) {
    public interface UserView{
        interface RegistrationPost{}
        interface PasswordPut{}
        interface LoginRequest{}
        interface UpdateRequest{}
    }
}
