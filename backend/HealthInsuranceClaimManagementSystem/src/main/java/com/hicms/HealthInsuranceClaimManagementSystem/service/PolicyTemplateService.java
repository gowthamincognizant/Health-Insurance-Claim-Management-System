package com.hicms.HealthInsuranceClaimManagementSystem.service;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateResponseDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateUpdateDTO;

import java.util.List;

public interface PolicyTemplateService {
    PolicyTemplateResponseDTO createPolicy(PolicyTemplateCreateDTO policyTemplateCreateDTO);
    List<PolicyTemplateResponseDTO> getAllActivePolicies();
    PolicyTemplateResponseDTO updatePolicyTemplate(Long policyTemplateId, PolicyTemplateUpdateDTO policyTemplateUpdateDTO);
    void disablePolicyTemplate(Long policyTemplateId);
}
