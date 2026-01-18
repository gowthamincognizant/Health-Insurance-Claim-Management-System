package com.hicms.HealthInsuranceClaimManagementSystem.controller.user;

import com.hicms.HealthInsuranceClaimManagementSystem.dto.user.UserCreateDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.dto.user.UserResponseDTO;
import com.hicms.HealthInsuranceClaimManagementSystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
        UserResponseDTO userResponseDTO = userService.createUser(userCreateDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }
}
