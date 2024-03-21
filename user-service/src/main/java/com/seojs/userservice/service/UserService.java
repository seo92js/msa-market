package com.seojs.userservice.service;

import com.seojs.userservice.dto.UserRequestDto;
import com.seojs.userservice.dto.UserResponseDto;
import com.seojs.userservice.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto getUserByUserId(String userId);
    List<User> getUserByAll();
}
