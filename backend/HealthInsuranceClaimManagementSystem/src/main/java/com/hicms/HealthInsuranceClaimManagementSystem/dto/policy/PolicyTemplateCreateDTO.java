package com.hicms.HealthInsuranceClaimManagementSystem.dto.policy;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyTemplateCreateDTO {

    @NotBlank(message = "Policy Name is required")
    private String policyName;

    @NotBlank(message = "Policy number is required")
    private String policyNumber;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Policy type is required")
    private PolicyType policyType;

    @NotNull(message = "Coverage amount is required")
    @Positive(message = "Coverage amount must be positive")
    private Double coverageAmount;

    @NotNull(message = "Premium amount is required")
    @Positive(message = "Premium amount should be positive")
    private Double premiumAmount;

    @NotNull(message = "Tenure in year is required")
    private Integer tenureInYears;

    @NotBlank(message = "Description is required")
    private String description;

}
