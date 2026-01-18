package com.hicms.HealthInsuranceClaimManagementSystem.dto.supportticket;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.SupportTicketPriority;
import com.hicms.HealthInsuranceClaimManagementSystem.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportTicketResponseDTO {
    private Long ticketId;
    private String subject;
    private String description;
    private SupportTicketPriority supportTicketPriority;
    private TicketStatus ticketStatus;
    private LocalDateTime createdAt;
    private Long userId;
    private Long claimId;
}
