package com.fintech.identityservice.controller;

import com.fintech.identityservice.request.VerificationRequest;
import com.fintech.identityservice.response.BvnResponse;
import com.fintech.identityservice.response.NinResponse;
import com.fintech.identityservice.service.IdentityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/identity")
@RequiredArgsConstructor
public class VerificationController {

    private final IdentityService identityService;

    @Value("${app.secret-key}")
    private String validSecretKey;

    @PostMapping("/bvn")
    public BvnResponse verifyBVN(@RequestBody VerificationRequest verificationRequest, @RequestHeader("X-API-KEY") String apiKey) {
        if (!validSecretKey.equals(apiKey)) {
            return BvnResponse.builder()
                    .statusCode("02")
                    .status("fail")
                    .message("Unauthorized")
                    .build();
        }
        return identityService.verifyBVN(verificationRequest);
    }

    @PostMapping("/nin")
    public NinResponse verifyNIN(@RequestBody VerificationRequest verificationRequest, @RequestHeader("X-API-KEY") String apiKey) {
        if (!validSecretKey.equals(apiKey)) {
            return NinResponse.builder()
                    .statusCode("02")
                    .status("fail")
                    .message("Unauthorized")
                    .build();
        }
        return identityService.verifyNIN(verificationRequest);
    }
}
