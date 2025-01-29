package com.bracepl.onboarding_service.application.interfaces;

import com.bracepl.onboarding_service.application.dtos.RegistrationDto;
import com.bracepl.onboarding_service.domain.model.ServiceResponse;

public interface InvestorUseCase {
    ServiceResponse register(RegistrationDto registrationDto);
}
