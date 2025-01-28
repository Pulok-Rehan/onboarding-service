package com.bracepl.onboarding_service.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String addressLine1;
    private String city;
    private String country;
    private String state;
    private String zipCode;
}
