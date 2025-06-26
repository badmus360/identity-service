package com.fintech.identityservice.service;


import com.fintech.identityservice.request.VerificationRequest;
import com.fintech.identityservice.response.BvnResponse;
import com.fintech.identityservice.response.NinResponse;

public interface IdentityService {
    BvnResponse verifyBVN(VerificationRequest verificationRequest);
    NinResponse verifyNIN(VerificationRequest verificationRequest);
}
