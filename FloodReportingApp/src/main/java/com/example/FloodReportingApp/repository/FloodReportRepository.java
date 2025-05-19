package com.example.FloodReportingApp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.FloodReportingApp.model.FloodReport;

import java.util.List;

@Repository
public interface FloodReportRepository extends MongoRepository<FloodReport, String>{
    List<FloodReport> findByDeviceId(String deviceId);
}