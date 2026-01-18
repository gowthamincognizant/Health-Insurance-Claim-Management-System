package com.hicms.HealthInsuranceClaimManagementSystem.service.impl;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.user.UserCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.user.UserResponseDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.enums.Role;
import com.hicms.HealthInsuranceClaimManagementSystem.model.User;
import com.hicms.HealthInsuranceClaimManagementSystem.repository.UserRepository;
import com.hicms.HealthInsuranceClaimManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        if (userRepository.existsByUserName(userCreateDTO.getUserName())){
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(userCreateDTO.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .userName(userCreateDTO.getUserName())
                .password(userCreateDTO.getPassword())
                .firstName(userCreateDTO.getFirstName())
                .lastName(userCreateDTO.getLastName())
                .email(userCreateDTO.getEmail())
                .phoneNumber(userCreateDTO.getPhoneNumber())
                .dateOfBirth(userCreateDTO.getDateOfBirth())
                .gender(userCreateDTO.getGender())
                .role(Role.USER)
                .build();
        User savedUser = userRepository.save(user);

        return UserResponseDTO.builder()
                .userId(savedUser.getUserId())
                .userName(savedUser.getUserName())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .phoneNumber(savedUser.getPhoneNumber())
                .role(savedUser.getRole())
                .createdAt(savedUser.getCreatedAt())
                .build();
    }
}
