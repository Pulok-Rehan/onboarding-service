package com.bracepl.onboarding_service.domain.services;

import com.bracepl.onboarding_service.application.dtos.AccountOpeningDto;
import com.bracepl.onboarding_service.application.interfaces.OpenAccountUseCase;
import com.bracepl.onboarding_service.domain.model.Account;
import com.bracepl.onboarding_service.domain.interfaces.AccountDomain;
import com.bracepl.onboarding_service.domain.model.Address;
import com.bracepl.onboarding_service.domain.model.BankDetails;
import com.bracepl.onboarding_service.domain.model.ServiceResponse;
import com.bracepl.onboarding_service.domain.utils.ValidationUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AccountService implements OpenAccountUseCase {

    private final AccountDomain accountDomain;

    public AccountService(AccountDomain accountDomain) {
        this.accountDomain = accountDomain;
    }

    @Override
    public ServiceResponse openAccount(AccountOpeningDto accountOpeningDto, MultipartFile nidFront, MultipartFile nidBack, MultipartFile signature) throws IOException {
        List<MultipartFile> files = Arrays.asList(nidFront, nidBack, signature);
        if (ValidationUtils.hasNullOrEmptyField(accountOpeningDto)) {
            return new ServiceResponse("Null value found");
        }
        if (ValidationUtils.hasEmptyFile(files)) {
            return new ServiceResponse("Null value found");
        }
        this.setFilesToDto(accountOpeningDto, nidFront, nidBack, signature);
        if (accountDomain.isDuplicateAccount(accountOpeningDto.getNid())){
            return new ServiceResponse("ALREADY HAS AN ACCOUNT WITH THIS NID");
        }

//        Account account = modelMapper.map(accountOpeningDto, Account.class);
        Account account = this.populateTOAccountObject(accountOpeningDto);
        accountDomain.save(account);
        return null;
    }

    private Account populateTOAccountObject(AccountOpeningDto accountOpeningDto) throws IOException {
        return Account.builder()
                .name(accountOpeningDto.getName())
                .gender(accountOpeningDto.getGender())
                .nid(accountOpeningDto.getNid())
                .fathersName(accountOpeningDto.getFathersName())
                .mothersName(accountOpeningDto.getMothersName())
                .dateOfBirth(accountOpeningDto.getDateOfBirth())
                .investorCode(this.generateUniqueCode())
                .adress(Address.builder()
                        .addressLine1(accountOpeningDto.getAddressLine1())
                        .city(accountOpeningDto.getCity())
                        .country(accountOpeningDto.getCountry())
                        .state(accountOpeningDto.getState())
                        .zipCode(accountOpeningDto.getZipCode())
                        .build())
                .bankDetails(BankDetails.builder()
                        .bankName(accountOpeningDto.getBankName())
                        .branchName(accountOpeningDto.getBranchName())
                        .routingNumber(accountOpeningDto.getBranchName())
                        .accountNo(accountOpeningDto.getAccountNo())
                        .build())
                .photo(this.convertToString(accountOpeningDto.getPhoto()))
                .nidBack(this.convertToString(accountOpeningDto.getNidBack()))
                .nidFront(this.convertToString(accountOpeningDto.getNidFront()))
                .signature(this.convertToString(accountOpeningDto.getSignature()))
                .build();
    }

    private String convertToString(MultipartFile file) throws IOException {
        String uploadDir = "/path/to/images/";
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return filePath.toString();
    }

    private String generateUniqueCode() {
        String datePart = new SimpleDateFormat("HHmmss").format(new Date());
        Random random = new Random();
        int randomPart = 1000 + random.nextInt(900);
        return randomPart + datePart;
    }

    private void setFilesToDto(AccountOpeningDto accountOpeningDto , MultipartFile nidFront, MultipartFile nidBack, MultipartFile signature){
        accountOpeningDto.setNidFront(nidFront);
        accountOpeningDto.setNidBack(nidBack);
        accountOpeningDto.setSignature(signature);
    }

}
