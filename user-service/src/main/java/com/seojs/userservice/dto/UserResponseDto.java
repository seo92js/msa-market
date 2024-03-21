package com.seojs.userservice.dto;

import com.seojs.userservice.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private String email;
    private String name;
    private String userId;

    private List<OrderResponseDto> orders = new ArrayList<>();

    public UserResponseDto(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.userId = user.getUserId();
    }
}
