package com.hicms.HealthInsuranceClaimManagementSystem.service;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.user.UserCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.user.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserCreateDTO userCreateDTO);
}
