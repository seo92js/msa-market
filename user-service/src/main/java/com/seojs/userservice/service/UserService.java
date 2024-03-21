package com.seojs.userservice.service;

import com.seojs.userservice.dto.UserRequestDto;
import com.seojs.userservice.dto.UserResponseDto;
import com.seojs.userservice.entity.User;
import com.seojs.userservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto getUserByUserId(String userId);
    List<User> getUserByAll();
    UserResponseDto getUserDetailsByEmail(String email);
}
