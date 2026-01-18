package com.hicms.HealthInsuranceClaimManagementSystem.dto.userpolicy;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPolicyCreateDTO {
    @NotNull(message = "Policy ID is required")
    private Long policyId;
}
