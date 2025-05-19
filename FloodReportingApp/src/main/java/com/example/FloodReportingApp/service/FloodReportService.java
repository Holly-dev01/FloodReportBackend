package com.example.FloodReportingApp.service;

import com.example.FloodReportingApp.repository.FloodReportRepository;
import com.example.FloodReportingApp.model.FloodReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FloodReportService {
    @Autowired
    private FloodReportRepository reportRepository;
    
    public FloodReport createReport(FloodReport report) {
      report.setTimestamp(new Date());
     return reportRepository.save(report);
     }

    public List<FloodReport> getAllReports() {
      return reportRepository.findAll();
    }  
}
