package com.example.Employee_Management_System.repository;

import com.example.Employee_Management_System.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("DeptRepository")
public interface DeptRepository extends MongoRepository<Department, String> {
}
