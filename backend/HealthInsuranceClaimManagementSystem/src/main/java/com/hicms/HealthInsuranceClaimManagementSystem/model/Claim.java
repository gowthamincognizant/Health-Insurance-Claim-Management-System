package com.hicms.HealthInsuranceClaimManagementSystem.model;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.ClaimStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "claims")
@Builder
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id")
    private Long claimId;

    @Column(name = "claim_number", unique = true, nullable = false)
    private String claimNumber;

    @Column(name = "claim_amount", nullable = false)
    private BigDecimal claimAmount;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClaimStatus claimStatus;

    @ManyToOne
    @JoinColumn(name = "user_policy_id", nullable = false)
    private UserPolicy userPolicy;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "claim")
    private List<Document> documents;

    @OneToMany(mappedBy = "claim")
    private List<SupportTicket> supportTickets;

    @CreationTimestamp
    @Column(name = "submission_date", updatable = false)
    private LocalDateTime submissionDate;
}
