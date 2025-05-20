package com.example.FloodReportingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FloodReportingApp.dto.FloodReportDTO;
import com.example.FloodReportingApp.model.FloodReport;
import com.example.FloodReportingApp.service.FloodReportService;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class FloodReportController {

  @Autowired
    private FloodReportService reportService;
    
    /**
     * Créer un nouveau rapport.
     */
   @PostMapping
    public ResponseEntity<FloodReport> createReport(@RequestBody FloodReportDTO reportDTO) {
        FloodReport report = reportService.createReport(reportDTO);
        return ResponseEntity.ok(report);
    }

    /**
     * Récupérer tous les rapports.
     */
   @GetMapping("/all")
   public ResponseEntity<List<FloodReportDTO>> getAllReports() {
     List<FloodReportDTO> reports = reportService.getAllReports();
     return ResponseEntity.ok(reports);
    }

    /**
      * Récupérer les rapports par type.
      */
  @GetMapping("/type/{type}")
  public ResponseEntity<List<FloodReportDTO>> getReportsByType(@PathVariable String type) {
    List<FloodReportDTO> reports = reportService.getReportsByType(type);
    return ResponseEntity.ok(reports);
  }

    /**
     * Récupérer les rapports par severity.
     */
  @GetMapping("/severity/{severity}")
  public ResponseEntity<List<FloodReportDTO>> getReportsBySeverity(@PathVariable String severity) {
    List<FloodReportDTO> reports = reportService.getReportsBySeverity(severity);
    return ResponseEntity.ok(reports);
  }
}