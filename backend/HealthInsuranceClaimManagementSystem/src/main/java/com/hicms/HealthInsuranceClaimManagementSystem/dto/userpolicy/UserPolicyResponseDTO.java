package com.hicms.HealthInsuranceClaimManagementSystem.dto.userpolicy;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPolicyResponseDTO {
    private Long userPolicyId;
    private Integer userId;
    private Long policyId;
    private String policyNumber;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;
    private PolicyStatus status;
}
