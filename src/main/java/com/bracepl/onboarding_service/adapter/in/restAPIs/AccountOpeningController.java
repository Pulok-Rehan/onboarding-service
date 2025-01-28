package com.bracepl.onboarding_service.adapter.in.restAPIs;

import com.bracepl.onboarding_service.application.dtos.AccountOpeningDto;
import com.bracepl.onboarding_service.application.interfaces.OpenAccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountOpeningController {

    private final OpenAccountUseCase openAccountUseCase;

    @Autowired
    public AccountOpeningController(OpenAccountUseCase openAccountUseCase) {
        this.openAccountUseCase = openAccountUseCase;
    }

    @PostMapping("/open")
    public void openAccount(@RequestBody AccountOpeningDto accountOpeningDto) {
        openAccountUseCase.openAccount(accountOpeningDto);
    }
}
