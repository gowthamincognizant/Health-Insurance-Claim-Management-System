package com.hicms.HealthInsuranceClaimManagementSystem.repository;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.PolicyStatus;
import com.hicms.HealthInsuranceClaimManagementSystem.model.PolicyTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PolicyTemplateRepository extends JpaRepository<PolicyTemplate, Long> {
    List<PolicyTemplate> findByStatus(PolicyStatus policyStatus);
}
