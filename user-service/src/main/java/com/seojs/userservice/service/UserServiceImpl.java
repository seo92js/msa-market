package com.seojs.userservice.service;

import com.seojs.userservice.dto.OrderResponseDto;
import com.seojs.userservice.dto.UserRequestDto;
import com.seojs.userservice.dto.UserResponseDto;
import com.seojs.userservice.entity.User;
import com.seojs.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user == null)
            throw new UsernameNotFoundException(username);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getEncryptedPassword(),
                true, true, true, true,
                new ArrayList<>());
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = User.builder()
                .email(userRequestDto.getEmail())
                .name(userRequestDto.getName())
                .userId(UUID.randomUUID().toString())
                .encryptedPassword(passwordEncoder.encode(userRequestDto.getPassword()))
                .build();

        userRepository.save(user);

        return new UserResponseDto(user);
    }

    @Override
    public UserResponseDto getUserByUserId(String userId) {
        User user = userRepository.findByUserId(userId);

        if (user == null)
            throw new UsernameNotFoundException("User not found");

        UserResponseDto userResponseDto = new UserResponseDto(user);

        List<OrderResponseDto> orders = new ArrayList<>();

        userResponseDto.setOrders(orders);

        return userResponseDto;
    }

    @Override
    public List<User> getUserByAll() {
        return userRepository.findAll();
    }

    @Override
    public UserResponseDto getUserDetailsByEmail(String email) {
        User user = userRepository.findByEmail(email);

        return new UserResponseDto(user);
    }
}
