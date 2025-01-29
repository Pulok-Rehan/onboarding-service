package com.bracepl.onboarding_service.adapter.out.interfaces;

import com.bracepl.onboarding_service.adapter.out.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByNid(String nidNumber);
}
