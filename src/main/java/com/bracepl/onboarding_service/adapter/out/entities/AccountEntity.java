package com.bracepl.onboarding_service.adapter.out.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "AccountDetails")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String investorCode;
    private String name;
    private String gender;
    private String nid;
    private String fathersName;
    private String mothersName;
    private LocalDate dateOfBirth;
    private String addressLine1;
    private String city;
    private String country;
    private String state;
    private String zipCode;
    private String bankName;
    private String branchName;
    private String routingNumber;
    private String accountNo;
    private String nidFront;
    private String nidBack;
    private String photo;
    private String signature;

}
