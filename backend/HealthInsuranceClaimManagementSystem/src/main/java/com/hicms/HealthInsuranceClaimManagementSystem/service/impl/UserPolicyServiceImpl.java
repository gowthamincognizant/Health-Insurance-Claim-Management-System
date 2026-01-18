package com.hicms.HealthInsuranceClaimManagementSystem.service.impl;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.userpolicy.UserPolicyCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.userpolicy.UserPolicyResponseDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyStatus;
import com.hicms.HealthInsuranceClaimManagementSystem.model.PolicyTemplate;
import com.hicms.HealthInsuranceClaimManagementSystem.model.User;
import com.hicms.HealthInsuranceClaimManagementSystem.model.UserPolicy;
import com.hicms.HealthInsuranceClaimManagementSystem.repository.PolicyTemplateRepository;
import com.hicms.HealthInsuranceClaimManagementSystem.repository.UserPolicyRepository;
import com.hicms.HealthInsuranceClaimManagementSystem.repository.UserRepository;
import com.hicms.HealthInsuranceClaimManagementSystem.service.UserPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserPolicyServiceImpl implements UserPolicyService {
    private final UserPolicyRepository userPolicyRepository;
    private final UserRepository userRepository;
    private final PolicyTemplateRepository policyTemplateRepository;
    @Override
    public UserPolicyResponseDTO buyPolicy(UserPolicyCreateDTO userPolicyCreateDTO, Integer loggedInUserId) {
        User user = userRepository.findById(loggedInUserId).orElseThrow(() ->
            new RuntimeException("User not found"));

        PolicyTemplate policyTemplate = policyTemplateRepository.findById(userPolicyCreateDTO.getPolicyId()).orElseThrow(() -> new RuntimeException("Policy not found"));

        UserPolicy userPolicy = UserPolicy.builder()
                .user(user)
                .policyTemplate(policyTemplate)
                .startDate(LocalDate.now())
                .endDate(policyTemplate.getEndDate())
                .policyStatus(PolicyStatus.ACTIVE)
                .build();

        UserPolicy saved = userPolicyRepository.save(userPolicy);
        return mapToResponse(saved);
    }

    @Override
    public List<UserPolicyResponseDTO> getMyPolicies(Integer loggedInUserId) {
        return userPolicyRepository.findByUserUserId(loggedInUserId).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private UserPolicyResponseDTO mapToResponse(UserPolicy userPolicy){
        return UserPolicyResponseDTO.builder()
                .userPolicyId(userPolicy.getUserPolicyId())
                .userId(userPolicy.getUser().getUserId())
                .policyId(userPolicy.getPolicyTemplate().getPolicyId())
                .startDate(userPolicy.getStartDate())
                .endDate(userPolicy.getEndDate())
                .status(userPolicy.getPolicyStatus())
                .status(userPolicy.getPolicyStatus())
                .build();
    }

}
