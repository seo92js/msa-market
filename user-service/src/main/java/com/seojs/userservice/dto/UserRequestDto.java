package com.seojs.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserRequestDto {
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    @Email
    private String email;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Email not be less than 2 characters")
    private String name;

    @NotNull(message = "Name cannot be null")
    @Size(min = 8, message = "Password must be equal or greater then 8 characters")
    private String password;
}
