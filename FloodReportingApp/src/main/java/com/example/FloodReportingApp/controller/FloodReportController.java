package com.example.FloodReportingApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FloodReportingApp.model.FloodReport;


@RestController
@RequestMapping("/api/reports")
public class FloodReportController {
    
@PostMapping
public ResponseEntity<FloodReport> createReport(@RequestBody FloodReport report) {
    FloodReport savedReport = reportService.createReport(report);
    return ResponseEntity.ok(savedReport);
}
}