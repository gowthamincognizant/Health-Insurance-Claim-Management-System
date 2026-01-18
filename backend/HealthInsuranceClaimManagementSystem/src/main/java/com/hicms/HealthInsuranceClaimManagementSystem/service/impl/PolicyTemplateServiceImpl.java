package com.hicms.HealthInsuranceClaimManagementSystem.service.impl;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateResponseDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateUpdateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyStatus;
import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyTemplateStatus;
import com.hicms.HealthInsuranceClaimManagementSystem.model.PolicyTemplate;
import com.hicms.HealthInsuranceClaimManagementSystem.repository.PolicyTemplateRepository;
import com.hicms.HealthInsuranceClaimManagementSystem.service.PolicyTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PolicyTemplateServiceImpl implements PolicyTemplateService {

    private final PolicyTemplateRepository policyTemplateRepository;

    @Override
    public PolicyTemplateResponseDTO createPolicy(PolicyTemplateCreateDTO policyTemplateCreateDTO) {
        PolicyTemplate policyTemplate = PolicyTemplate.builder()
                .policyTemplateName(policyTemplateCreateDTO.getPolicyTemplateName())
                .policyTemplateNumber(policyTemplateCreateDTO.getPolicyTemplateNumber())
                .policyTemplateType(policyTemplateCreateDTO.getPolicyTemplateType())
                .coverageAmount(policyTemplateCreateDTO.getCoverageAmount())
                .premiumAmount(policyTemplateCreateDTO.getPremiumAmount())
                .tenureInYears(policyTemplateCreateDTO.getTenureInYears())
                .description(policyTemplateCreateDTO.getDescription())
                .policyTemplateStatus(PolicyTemplateStatus.ACTIVE)
                .build();
        PolicyTemplate saved = policyTemplateRepository.save(policyTemplate);
        return mapToResponse(saved);
    }

    @Override
    public List<PolicyTemplateResponseDTO> getAllActivePolicies() {
        return policyTemplateRepository.findByStatus(PolicyTemplateStatus.ACTIVE).stream().map(this::mapToResponse).toList();
    }

    @Override
    public PolicyTemplateResponseDTO updatePolicyTemplate(Long policyTemplateId, PolicyTemplateUpdateDTO policyTemplateUpdateDTO) {
        PolicyTemplate policyTemplate = policyTemplateRepository.findById(policyTemplateId).orElseThrow(() -> new RuntimeException("Policy not found"));
        policyTemplate.setPolicyTemplateName(policyTemplateUpdateDTO.getPolicyTemplateName());
        policyTemplate.setPolicyTemplateType(policyTemplateUpdateDTO.getPolicyTemplateType());
        policyTemplate.setCoverageAmount(policyTemplateUpdateDTO.getCoverageAmount());
        policyTemplate.setPremiumAmount(policyTemplateUpdateDTO.getPremiumAmount());
        policyTemplate.setTenureInYears(policyTemplateUpdateDTO.getTenureInYears());
        policyTemplate.setDescription(policyTemplate.getDescription());
        return mapToResponse(policyTemplateRepository.save(policyTemplate));
    }

    @Override
    public void disablePolicyTemplate(Long policyTemplateId) {
        PolicyTemplate policyTemplate = policyTemplateRepository.findById(policyTemplateId).orElseThrow(() -> new RuntimeException("Policy not found"));
        policyTemplate.setPolicyTemplateStatus(PolicyTemplateStatus.INACTIVE);
        policyTemplateRepository.save(policyTemplate);
    }


    private PolicyTemplateResponseDTO mapToResponse(PolicyTemplate policyTemplate){
        return PolicyTemplateResponseDTO.builder()
                .policyTemplateId(policyTemplate.getPolicyTemplateId())
                .policyTemplateType(policyTemplate.getPolicyTemplateType())
                .policyTemplateName(policyTemplate.getPolicyTemplateName())
                .policyTemplateNumber(policyTemplate.getPolicyTemplateNumber())
                .coverageAmount(policyTemplate.getCoverageAmount())
                .premiumAmount(policyTemplate.getPremiumAmount())
                .tenureInYears(policyTemplate.getTenureInYears())
                .description(policyTemplate.getDescription())
                .policyTemplateStatus(policyTemplate.getPolicyTemplateStatus())
                .build();
    }
}
