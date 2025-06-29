package com.fintech.identityservice.service;

import com.fintech.identityservice.request.VerificationRequest;
import com.fintech.identityservice.response.BvnResponse;
import com.fintech.identityservice.response.NinResponse;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class IdentityServiceImpl implements IdentityService{
    private final Gson gson;

    @Override
    public BvnResponse verifyBVN(VerificationRequest verificationRequest) {

        String bvn = verificationRequest.getNumber();
        String phoneNumber = "";
        String dateOfBirth = "";
        String address = "";
        String nin = "";
        String firstName = "";
        String lastName = "";
        String middleName = "";
        String email = "";

        log.info("bvn. = {}", bvn);

        List<String> listOfBvn = List.of("59220822994", "59220822888", "70252300667",
                "78365193362", "51142258038", "70553458668", "34313900345", "78380094340",
                "03206889070", "60533704970");

        if (!listOfBvn.contains(bvn)) {
            return BvnResponse.builder()
                    .statusCode("02")
                    .status("fail")
                    .message("bvn is not valid")
                    .build();
        }

        if (Objects.equals(bvn, "59220822994")) {
            phoneNumber = "08034567892";
            dateOfBirth = "07/08/1997";
            address = "lagos street";
            nin = "60539994999";
            firstName = "John";
            lastName = "Doe";
            middleName = "Job";
            email = "johndoe@gmail.com";
        }

        String bvnResponseData = "{" +
                "\"result\": { " +
                "       \"requestReference\": \"E5fAXe757848871_22\"," +
                "        \"bvnNumber\": \"" + bvn + "\"," +
                "        \"enrolmentBranch\": \"44\"," +
                "        \"formattedRegistrationDate\": \"07-Jan-2020\"," +
                "        \"levelOfAccount\": \"Level 1 - Low Level Accounts\"," +
                "        \"nin\": \""+ nin +"\"," +
                "        \"verificationStatus\": \"VERIFIED\"," +
                "        \"serviceType\": \"BVN Verification without Image\"," +
                "        \"personalInfo\": {" +
                "            \"firstName\": \"" + firstName + "\"," +
                "            \"middleName\": \"" + middleName + "\"," +
                "            \"lastName\": \"" + lastName + "\"," +
                "            \"fullName\": \"" + firstName + " " + lastName + "\"," +
                "            \"email\": \"" + email + "\"," +
                "            \"gender\": \"Male\"," +
                "            \"phoneNumber\": \"" + phoneNumber + "\"," +
                "            \"dateOfBirth\": \"" + dateOfBirth + "\"," +
                "            \"lgaOfOrigin\": \"Awka South\"," +
                "            \"stateOfOrigin\": \"Anambra State\"," +
                "            \"nationality\": \"Nigeria\"," +
                "            \"maritalStatus\": \"single\"" +
                "        }," +
                "        \"residentialInfo\": {" +
                "            \"stateOfResidence\": \"FCT\"," +
                "            \"lgaOfResidence\": \"Bwari\"," +
                "            \"residentialAddress\": \"" + address + "\"" +
                "        }" +
                "    }," +
                "    \"statusCode\": 200," +
                "    \"status\": \"Success\"," +
                "    \"message\": \"BVN Verification Completed Successfully\"" +
                "}";

        log.info("Bvn Response Data {}", gson.toJson(bvnResponseData));
        return gson.fromJson(bvnResponseData, BvnResponse.class);
    }

    @Override
    public NinResponse verifyNIN(VerificationRequest verificationRequest) {

        String phoneNumber = "";
        String dateOfBirth = "";
        String address = "";
        String nin = verificationRequest.getNumber();
        String firstName = "";
        String lastName = "";
        String middleName = "";
        String email = "";

        log.info("nin. = {}", nin);

        List<String> listOfNin = List.of("42937562241", "42937562333", "93674303747", "30163024587",
                "35937256249", "39815201940", "31132775466", "80131380969");

        if (!listOfNin.contains(nin)) {
            return  NinResponse.builder()
                    .statusCode("02")
                    .status("fail")
                    .message("nin is not valid")
                    .build();
        }

        if (Objects.equals(nin, "42937562241")) {
            phoneNumber = "08034567892";
            dateOfBirth = "07/08/1997";
            address = "lagos street";
            nin = "60539994999";
            firstName = "John";
            lastName = "Doe";
            middleName = "Job";
            email = "johndoe@gmail.com";
        }

        String ninResponseData = "{" +
                "\"result\": {" +
                "    \"requestReference\": \"E5fAXe757848871_22\"," +
                "    \"ninNumber\": \""+ nin + "\"," +
                "    \"documentNo\": \"D123456789\"," +
                "    \"verificationStatus\": \"VERIFIED\"," +
                "    \"serviceType\": \"NIN Verification with Image\"," +
                "    \"personalInfo\": {" +
                "        \"title\": \"Mr.\"," +
                "        \"firstName\":  \""+ firstName + "\"," +
                "        \"middleName\": \""+ middleName + "\"," +
                "        \"lastName\": \"" + lastName + "\"," +
                "        \"fullName\": \"" + firstName +" "+ lastName + "\"," +
                "        \"maidenName\": \"\"," +
                "        \"gender\": \"Male\"," +
                "        \"email\": \""+ email + "\"," +
                "        \"phoneNumber\": \"" + phoneNumber + "\"," +
                "        \"dateOfBirth\":\"" + dateOfBirth + "\"," +
                "        \"height\": \"5.8\"," +
                "        \"maritalStatus\": \"single\"," +
                "        \"religion\": \"Christianity\"," +
                "        \"signature\": \"signature-image-url\"" +
                "    }," +
                "    \"nextOfKin\": {" +
                "        \"firstname\": \"Kola\"," +
                "        \"surname\": \"Binuyo\"," +
                "        \"address\": \"Main street, Lagos\"," +
                "        \"lga\": \"Ikeja\"," +
                "        \"town\": \"Lagos\"," +
                "        \"state\": \"Lagos State\"" +
                "    }," +
                "    \"residentialInfo\": {" +
                "        \"address\": \""+address+"\"," +
                "        \"lgaOfResidence\": \"Bwari\"," +
                "        \"stateOfResidence\": \"FCT\"," +
                "        \"residenceStatus\": \"Permanent\"" +
                "    }," +
                "    \"indigeneInfo\": {" +
                "        \"lgaOfOrigin\": \"Awka South\"," +
                "        \"placeOfOrigin\": \"Awka\"," +
                "        \"stateOfOrigin\": \"Anambra State\"" +
                "    }" +
                "}," +
                "\"statusCode\": \"200\"," +
                "\"message\": \"NIN Verification Completed Successfully\"," +
                "\"status\": \"Success\"" +
                "}";

        log.info("NINresponse :: {}", gson.toJson(ninResponseData));
        return gson.fromJson(ninResponseData, NinResponse.class);
    }
}
