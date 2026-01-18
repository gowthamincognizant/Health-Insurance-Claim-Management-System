package com.hicms.HealthInsuranceClaimManagementSystem.dto.policy;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyTemplateStatus;
import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyTemplateType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyTemplateResponseDTO {
    private Long policyTemplateId;
    private String policyTemplateName;
    private String policyTemplateNumber;
    private PolicyTemplateType policyTemplateType;
    private Double coverageAmount;
    private Double premiumAmount;
    private Integer tenureInYears;
    private PolicyTemplateStatus policyTemplateStatus;
    private String description;
}
