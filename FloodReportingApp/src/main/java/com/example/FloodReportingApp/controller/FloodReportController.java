package com.example.FloodReportingApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FloodReportingApp.dto.FloodReportDTO;
import com.example.FloodReportingApp.model.FloodReport;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class FloodReportController {

  @PostMapping
  public ResponseEntity<FloodReport> createReport(@RequestBody FloodReport report) {
    FloodReport savedReport = reportService.createReport(report);
    return ResponseEntity.ok(savedReport);
   }

   @GetMapping
   public ResponseEntity<List<FloodReportDTO>> getAllReports() {
     List<FloodReportDTO> reports = reportService.getAllReports();
     return ResponseEntity.ok(reports);
    }
    
   @GetMapping("/device/{deviceId}")
   public ResponseEntity<List<FloodReport>> getReportsByDeviceId(@PathVariable String deviceId) {
     List<FloodReport> reports = reportService.getReportsByDeviceId(deviceId);
     return ResponseEntity.ok(reports);
   }

  @PostMapping
  public ResponseEntity<FloodReport> createReport(@RequestBody FloodReportDTO reportDTO) {
    FloodReport report = reportService.createReport(reportDTO);
    return ResponseEntity.ok(report);
  }

  @GetMapping("/type/{type}")
  public ResponseEntity<List<FloodReportDTO>> getReportsByType(@PathVariable String type) {
    List<FloodReportDTO> reports = reportService.getReportsByType(type);
    return ResponseEntity.ok(reports);
  }
}