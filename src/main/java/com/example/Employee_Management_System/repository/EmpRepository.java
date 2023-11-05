package com.example.Employee_Management_System.repository;

import com.example.Employee_Management_System.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("EmpRepository")
public interface EmpRepository extends JpaRepository<Employee, Long> {
}
