package com.example.FloodReportingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.FloodReportingApp.service.AuthService;

@SpringBootApplication
public class FloodReportingAppApplication {

    @Autowired
    private AuthService authService;
	public static void main(String[] args) {
		SpringApplication.run(FloodReportingAppApplication.class, args);
	}

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Initialiser l'admin par défaut
            authService.initDefaultAdmin();
        };
    }

}
