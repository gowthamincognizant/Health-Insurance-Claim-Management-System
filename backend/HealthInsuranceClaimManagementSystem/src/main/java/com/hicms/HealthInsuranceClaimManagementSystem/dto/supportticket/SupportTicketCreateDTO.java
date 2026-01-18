package com.hicms.HealthInsuranceClaimManagementSystem.dto.supportticket;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.SupportTicketPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportTicketCreateDTO {
    @NotBlank(message = "Subject is required")
    @Size(max = 100, message = "Subject cannot exceed 100 characters")
    private String subject;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotNull(message = "Priority is required")
    private SupportTicketPriority supportTicketPriority;

    @NotNull(message = "Claim ID is required")
    private Long claimId;
}
