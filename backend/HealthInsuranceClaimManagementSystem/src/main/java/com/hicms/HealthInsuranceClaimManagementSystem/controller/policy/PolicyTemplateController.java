package com.hicms.HealthInsuranceClaimManagementSystem.controller.policy;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateResponseDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.policy.PolicyTemplateUpdateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.service.PolicyTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyTemplateController {
    private final PolicyTemplateService policyTemplateService;

    @PostMapping
    public ResponseEntity<PolicyTemplateResponseDTO> createPolicy(@Valid @RequestBody PolicyTemplateCreateDTO policyTemplateCreateDTO){
        return new ResponseEntity<>(
                policyTemplateService.createPolicy(policyTemplateCreateDTO), HttpStatus.CREATED
        );
    }

    @GetMapping
    public List<PolicyTemplateResponseDTO> getAllActivePolicies(){
        return policyTemplateService.getAllActivePolicies();
    }

    @PutMapping("/{policyTemplateId}")
    public PolicyTemplateResponseDTO updatePolicy(@PathVariable Long policyTemplateId, @Valid @RequestBody PolicyTemplateUpdateDTO policyTemplateUpdateDTO){
        return policyTemplateService.updatePolicyTemplate(policyTemplateId, policyTemplateUpdateDTO);
    }

    @PatchMapping("/{policyTemplateId}")
    public ResponseEntity<Void> disablePolicy(@PathVariable Long policyTemplateId){
        policyTemplateService.disablePolicyTemplate(policyTemplateId);
        return ResponseEntity.noContent().build();
    }

}
