package com.hicms.HealthInsuranceClaimManagementSystem.dto.policy;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyStatus;
import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyTemplateResponseDTO {
    private Long policyId;
    private String policyName;
    private String policyNumber;
    private PolicyType policyType;
    private Double coverageAmount;
    private Double premiumAmount;
    private Integer tenureInYears;
    private String description;
    private PolicyStatus policyStatus;
}
