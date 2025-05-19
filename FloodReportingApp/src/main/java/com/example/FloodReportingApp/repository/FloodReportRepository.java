package com.example.FloodReportingApp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloodReportRepository extends MongoRepository<FloodReport, String>{

}
