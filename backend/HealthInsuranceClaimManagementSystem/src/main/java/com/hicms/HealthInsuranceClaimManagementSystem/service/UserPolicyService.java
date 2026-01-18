package com.hicms.HealthInsuranceClaimManagementSystem.service;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.userpolicy.UserPolicyCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.userpolicy.UserPolicyResponseDTO;

import java.util.List;

public interface UserPolicyService {
    UserPolicyResponseDTO buyPolicy(UserPolicyCreateDTO userPolicyCreateDTO, Integer loggedInUserId);
    List<UserPolicyResponseDTO> getMyPolicies(Integer loggedInUserId);
}
