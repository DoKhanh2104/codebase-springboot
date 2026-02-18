package com.example.identity_service.controller;

import com.example.identity_service.dto.request.AuthRequest;
import com.example.identity_service.dto.response.ApiResponse;
import com.example.identity_service.dto.response.AuthResponse;
import com.example.identity_service.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ApiResponse<AuthResponse> authenticate(@RequestBody AuthRequest authRequest){

       boolean result = authenticationService.authenticate(authRequest);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAuthenticated(result);

        ApiResponse<AuthResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(authResponse);
        apiResponse.setCode(1000);
        return apiResponse;
    }
}
