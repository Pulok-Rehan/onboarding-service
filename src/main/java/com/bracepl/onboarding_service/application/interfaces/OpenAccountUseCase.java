package com.bracepl.onboarding_service.application.interfaces;


import com.bracepl.onboarding_service.application.dtos.AccountOpeningDto;
import com.bracepl.onboarding_service.domain.model.ServiceResponse;

import java.io.IOException;

public interface OpenAccountUseCase {
    ServiceResponse openAccount(AccountOpeningDto dto) throws IOException;
}
