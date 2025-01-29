package com.bracepl.onboarding_service.domain.interfaces;


import com.bracepl.onboarding_service.domain.model.Account;

public interface AccountDomain {
    Account save(Account account);
    boolean isDuplicateAccount(String nidNumber);
}
