package com.bracepl.onboarding_service.application.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class AccountOpeningDto {
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
    private MultipartFile nidFront;
    private MultipartFile nidBack;
    private MultipartFile photo;
    private MultipartFile signature;


}
