package com.example.FloodReportingApp.service;

import com.example.FloodReportingApp.repository.FloodReportRepository;
import com.example.FloodReportingApp.dto.FloodReportDTO;
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
    public List<FloodReport> getReportsByDeviceId(String deviceId) {
      return reportRepository.findByDeviceId(deviceId);
    }

  public FloodReport createReport(FloodReportDTO reportDTO) {
    FloodReport report = new FloodReport();
    report.setType(reportDTO.getType());
    report.setDescription(reportDTO.getDescription());
    report.setLatitude(reportDTO.getLatitude());
    report.setLongitude(reportDTO.getLongitude());
    report.setTimestamp(new Date());
    report.setDeviceId(reportDTO.getDeviceId());
    
    return reportRepository.save(report);
  }
}
