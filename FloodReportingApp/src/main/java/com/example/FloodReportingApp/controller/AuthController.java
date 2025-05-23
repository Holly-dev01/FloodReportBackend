package com.example.FloodReportingApp.controller;

import com.example.FloodReportingApp.dto.AuthRequestDTO;
import com.example.FloodReportingApp.dto.AuthResponseDTO;
import com.example.FloodReportingApp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authRequest) {
        AuthResponseDTO response = authService.authenticate(authRequest);
        return ResponseEntity.ok(response);
    }
}