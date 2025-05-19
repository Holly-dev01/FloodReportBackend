package com.example.FloodReportingApp.service;

import com.example.FloodReportingApp.repository.FloodReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FloodReportService {
    @Autowired
    private FloodReportRepository reportRepository;
    
    // Méthodes à implémenter
}
