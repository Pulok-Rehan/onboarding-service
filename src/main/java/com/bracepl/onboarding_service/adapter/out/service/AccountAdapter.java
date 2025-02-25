package com.bracepl.onboarding_service.adapter.out.service;

import com.bracepl.onboarding_service.adapter.out.entities.AccountEntity;
import com.bracepl.onboarding_service.adapter.out.interfaces.AccountRepository;
import com.bracepl.onboarding_service.domain.model.Account;
import com.bracepl.onboarding_service.domain.interfaces.AccountDomain;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AccountAdapter implements AccountDomain {
    private final AccountRepository accountRepository;

    public AccountAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity =AccountEntity.builder()
                .name(account.getName())
                .build();
        accountRepository.save(accountEntity);
        return null;
    }

    @Override
    public boolean isDuplicateAccount(String nidNumber) {
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findByNid(nidNumber);
        if (optionalAccountEntity.isPresent()){
            return true;
        }
        return false;
    }
}
