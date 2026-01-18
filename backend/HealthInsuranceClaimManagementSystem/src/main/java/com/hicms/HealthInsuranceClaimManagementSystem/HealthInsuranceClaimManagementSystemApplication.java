package com.hicms.HealthInsuranceClaimManagementSystem;

import com.hicms.HealthInsuranceClaimManagementSystem.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HealthInsuranceClaimManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(HealthInsuranceClaimManagementSystemApplication.class, args);
	}

}
