package com.bracepl.onboarding_service.domain.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String name;
    private String gender;
    private String nid;
    private String fathersName;
    private String mothersName;
    private LocalDate dateOfBirth;
    private String investorCode;
    private Address adress;
    private BankDetails bankDetails;
    private String nidFront;
    private String nidBack;
    private String photo;
    private String signature;
}
