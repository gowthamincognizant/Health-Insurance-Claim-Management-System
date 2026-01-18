package com.hicms.HealthInsuranceClaimManagementSystem.dto.policy;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyTemplateType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyTemplateUpdateDTO {
    @NotBlank(message = "Policy template name is required")
    private String policyTemplateName;

    @NotNull(message = "Policy template type is required")
    private PolicyTemplateType policyTemplateType;

    @NotNull(message = "Coverage amount is required")
    @Positive(message = "Coverage amount should be greater than 0")
    private Double coverageAmount;

    @NotNull
    @Positive(message = "Premium amount should be greater than 0")
    private Double premiumAmount;

    @NotNull
    @Positive
    private Integer tenureInYears;

    @NotBlank(message = "Description is required")
    private String description;
}
