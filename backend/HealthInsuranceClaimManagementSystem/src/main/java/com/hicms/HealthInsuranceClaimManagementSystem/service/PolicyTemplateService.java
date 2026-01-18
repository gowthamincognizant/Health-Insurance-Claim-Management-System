package com.hicms.HealthInsuranceClaimManagementSystem.service;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateResponseDTO;

import java.util.List;

public interface PolicyTemplateService {
    PolicyTemplateResponseDTO createPolicy(PolicyTemplateCreateDTO policyTemplateCreateDTO);
    List<PolicyTemplateResponseDTO> getAllActivePolicies();
}
