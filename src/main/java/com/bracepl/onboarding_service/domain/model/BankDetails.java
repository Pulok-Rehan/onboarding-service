package com.bracepl.onboarding_service.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankDetails {
    private String bankName;
    private String branchName;
    private String routingNumber;
    private String accountNo;
}
