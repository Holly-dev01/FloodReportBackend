package com.example.FloodReportingApp.service;

import com.example.FloodReportingApp.repository.FloodReportRepository;
import com.example.FloodReportingApp.dto.FloodReportDTO;
import com.example.FloodReportingApp.model.FloodReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<FloodReportDTO> getAllReports() {
      List<FloodReportDTO> reportDTOList = new ArrayList<>();
      reportRepository.findAll().forEach(report -> {
        reportDTOList.add(convertToDTO(report));

      });
      return reportDTOList;
    } 

    public List<FloodReport> getReportsByDeviceId(String deviceId) {
      return reportRepository.findByDeviceId(deviceId);
    }

    public List<FloodReportDTO> getReportsBySeverity(String severity) {
      List<FloodReportDTO> reportDTOList = new ArrayList<>();
      reportRepository.findBySeverity(severity).forEach(report -> {
        reportDTOList.add(convertToDTO(report));
      });
      return reportDTOList;
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

  private FloodReportDTO convertToDTO(FloodReport report) {
    FloodReportDTO dto = new FloodReportDTO();
    dto.setId(report.getId());
    dto.setType(report.getType());
    dto.setDescription(report.getDescription());
    dto.setLatitude(report.getLatitude());
    dto.setLongitude(report.getLongitude());
    dto.setTimestamp(report.getTimestamp());
    dto.setDeviceId(report.getDeviceId());
    dto.setSeverity(report.getSeverity());
    return dto;
  }
}
