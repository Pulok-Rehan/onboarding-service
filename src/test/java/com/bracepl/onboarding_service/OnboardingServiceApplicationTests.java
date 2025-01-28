package com.bracepl.onboarding_service;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnboardingServiceApplicationTests {

	@Test
	void contextLoads() {
		test test = com.bracepl.onboarding_service.test.builder()
				.name("John Doe")
				.build();
		System.out.println(test);
	}

}
