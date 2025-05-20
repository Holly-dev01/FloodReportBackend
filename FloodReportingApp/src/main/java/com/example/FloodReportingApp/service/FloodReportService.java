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
    
     //Créer un nouveau rapport
    public FloodReport createReport(FloodReportDTO reportDTO) {
        FloodReport report = new FloodReport(
                reportDTO.getType(),
                reportDTO.getDescription(),
                reportDTO.getLatitude(),
                reportDTO.getLongitude(),
                new Date(),
                reportDTO.getDeviceId(),
                reportDTO.getSeverity()
        );
        return reportRepository.save(report);
    }

     // Récupérer tous les rapports
    public List<FloodReportDTO> getAllReports() {
      List<FloodReportDTO> reportDTOList = new ArrayList<>();
      reportRepository.findAll().forEach(report -> {
        reportDTOList.add(convertToDTO(report));
      });
      return reportDTOList;
    } 

    // Récupérer les rapports par severity
    public List<FloodReportDTO> getReportsBySeverity(String severity) {
      List<FloodReportDTO> reportDTOList = new ArrayList<>();
      reportRepository.findBySeverity(severity).forEach(report -> {
        reportDTOList.add(convertToDTO(report));
      });
      return reportDTOList;
    }

    /**
     * Conversion d'un FloodReport en FloodReportDTO.
     */
    private FloodReportDTO convertToDTO(FloodReport report) {
        return new FloodReportDTO(
                report.getId(),
                report.getType(),
                report.getDescription(),
                report.getLatitude(),
                report.getLongitude(),
                report.getTimestamp(),
                report.getDeviceId(),
                report.getSeverity()
        );
    }
}
