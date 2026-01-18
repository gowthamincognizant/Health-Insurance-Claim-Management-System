package com.hicms.HealthInsuranceClaimManagementSystem.service.impl;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateResponseDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyStatus;
import com.hicms.HealthInsuranceClaimManagementSystem.model.PolicyTemplate;
import com.hicms.HealthInsuranceClaimManagementSystem.repository.PolicyTemplateRepository;
import com.hicms.HealthInsuranceClaimManagementSystem.service.PolicyTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PolicyTemplateServiceImpl implements PolicyTemplateService {

    private final PolicyTemplateRepository policyTemplateRepository;

    @Override
    public PolicyTemplateResponseDTO createPolicy(PolicyTemplateCreateDTO policyTemplateCreateDTO) {
        PolicyTemplate policyTemplate = PolicyTemplate.builder()
                .policyName(policyTemplateCreateDTO.getPolicyName())
                .policyNumber(policyTemplateCreateDTO.getPolicyNumber())
                .policyType(policyTemplateCreateDTO.getPolicyType())
                .coverageAmount(policyTemplateCreateDTO.getCoverageAmount())
                .premiumAmount(policyTemplateCreateDTO.getPremiumAmount())
                .tenureInYears(policyTemplateCreateDTO.getTenureInYears())
                .description(policyTemplateCreateDTO.getDescription())
                .status(PolicyStatus.ACTIVE)
                .build();
        PolicyTemplate saved = policyTemplateRepository.save(policyTemplate);
        return mapToResponse(saved);
    }

    @Override
    public List<PolicyTemplateResponseDTO> getAllActivePolicies() {
        return policyTemplateRepository.findByStatus(PolicyStatus.ACTIVE).stream().map(this::mapToResponse).toList();
    }

    private PolicyTemplateResponseDTO mapToResponse(PolicyTemplate policyTemplate){
        return PolicyTemplateResponseDTO.builder()
                .policyId(policyTemplate.getPolicyId())
                .policyName(policyTemplate.getPolicyName())
                .policyNumber(policyTemplate.getPolicyNumber())
                .policyType(policyTemplate.getPolicyType())
                .coverageAmount(policyTemplate.getCoverageAmount())
                .premiumAmount(policyTemplate.getPremiumAmount())
                .tenureInYears(policyTemplate.getTenureInYears())
                .description(policyTemplate.getDescription())
                .policyStatus(policyTemplate.getStatus())
                .build();
    }
}
