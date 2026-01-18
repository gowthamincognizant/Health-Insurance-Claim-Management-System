package com.hicms.HealthInsuranceClaimManagementSystem.dto.auth;

import com.hicms.HealthInsuranceClaimManagementSystem.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private Long userId;
    private String userName;
    private String email;
    private Role role;
    private String message;
}
