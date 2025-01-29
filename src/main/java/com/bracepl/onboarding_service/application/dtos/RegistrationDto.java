package com.bracepl.onboarding_service.application.dtos;

public record RegistrationDto(
        String emailAddress,
        String password,
        String investorCode
) {
}
