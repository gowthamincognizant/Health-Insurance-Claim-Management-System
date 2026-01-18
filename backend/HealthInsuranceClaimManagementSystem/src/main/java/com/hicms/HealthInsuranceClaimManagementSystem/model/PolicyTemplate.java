package com.hicms.HealthInsuranceClaimManagementSystem.model;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyTemplateStatus;
import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyTemplateType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "policies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyTemplateId;

    @Column(name = "policy_name", nullable = false)
    private String policyTemplateName;

    @Column(name = "policy_number", unique = true, nullable = false)
    private String policyTemplateNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "policy_type", nullable = false)
    private PolicyTemplateType policyTemplateType;

    @Column(name = "coverage_amount", nullable = false)
    private Double coverageAmount;

    @Column(name = "premium_amount", nullable = false)
    private Double premiumAmount;

    @Column(name = "tenure_in_years", nullable = false)
    private Integer tenureInYears;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "policy_template_status", nullable = false)
    private PolicyTemplateStatus policyTemplateStatus;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
