package com.hicms.HealthInsuranceClaimManagementSystem.controller.userpolicy;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.userpolicy.UserPolicyCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.userpolicy.UserPolicyResponseDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.service.UserPolicyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-policies")
@RequiredArgsConstructor
public class UserPolicyController {
    private final UserPolicyService userPolicyService;

    @PostMapping("/buy")
    public ResponseEntity<UserPolicyResponseDTO> buyPolicy(@Valid @RequestBody UserPolicyCreateDTO userPolicyCreateDTO){
        Integer loggedInUserId = 1;
        UserPolicyResponseDTO userPolicyResponseDTO = userPolicyService.buyPolicy(userPolicyCreateDTO, loggedInUserId);
        return new ResponseEntity<>(userPolicyResponseDTO, HttpStatus.CREATED);
    }

    public ResponseEntity<List<UserPolicyResponseDTO>> getMyPolicies(){
        Integer loggedInUserId = 1;
        List<UserPolicyResponseDTO> policies = userPolicyService.getMyPolicies(loggedInUserId);
        return ResponseEntity.ok(policies);
    }
}
