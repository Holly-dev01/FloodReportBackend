package com.example.FloodReportingApp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloodReportRepository extends MongoRepository<FloodReport, String>{

}
