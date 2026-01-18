package com.hicms.HealthInsuranceClaimManagementSystem.repository;

import com.hicms.HealthInsuranceClaimManagementSystem.model.UserPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPolicyRepository extends JpaRepository<UserPolicy, Long> {
    List<UserPolicy> findByUserUserId(Integer userId);
    List<UserPolicy> findByPolicyPolicyId(Long policyId);
}
