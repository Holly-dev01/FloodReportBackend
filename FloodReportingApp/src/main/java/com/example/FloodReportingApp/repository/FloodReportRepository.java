package com.example.FloodReportingApp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloodReportRepository extends MongoRepository<FloodReport, String>{
    List<FloodReport> findByDeviceId(String deviceId);
}