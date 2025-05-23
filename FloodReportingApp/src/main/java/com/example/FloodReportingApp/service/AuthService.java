package com.example.FloodReportingApp.service;

import com.example.FloodReportingApp.dto.AuthRequestDTO;
import com.example.FloodReportingApp.dto.AuthResponseDTO;
import com.example.FloodReportingApp.model.Admin;
import com.example.FloodReportingApp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepository;

    // Méthode pour vérifier les identifiants
    public AuthResponseDTO authenticate(AuthRequestDTO authRequest) {
        Admin admin = adminRepository.findByUsername(authRequest.getUsername());
        
        if (admin != null && admin.getPassword().equals(authRequest.getPassword())) {
            // Authentification réussie, générer un token simple
            String token = UUID.randomUUID().toString();
            
            return new AuthResponseDTO(true, token, "Authentification réussie");
        } else {
            // Authentification échouée
            return new AuthResponseDTO(false, null, "Identifiants invalides");
        }
    }
    
    // Méthode pour initialiser un admin par défaut si aucun n'existe
    public void initDefaultAdmin() {
        if (adminRepository.count() == 0) {
            Admin defaultAdmin = new Admin("holly", "holly");
            adminRepository.save(defaultAdmin);
        }
    }
}