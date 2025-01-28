package com.bracepl.onboarding_service.adapter.out.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name = "Bank")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bankName;
    private String branchName;
    private String routingNumber;
    private String accountNo;
}
