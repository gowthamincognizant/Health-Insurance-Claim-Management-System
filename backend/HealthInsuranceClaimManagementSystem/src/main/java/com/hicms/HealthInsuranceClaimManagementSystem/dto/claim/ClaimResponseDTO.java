package com.hicms.HealthInsuranceClaimManagementSystem.dto.claim;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimResponseDTO {
    private Long claimId;
    private String claimNumber;
    private BigDecimal claimAmount;
    private String description;
    private String claimStatus;
    private Long policyId;
    private LocalDateTime createdAt;
}
