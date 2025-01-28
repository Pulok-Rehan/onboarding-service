package com.bracepl.onboarding_service.adapter.out.interfaces;

import com.bracepl.onboarding_service.adapter.out.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
