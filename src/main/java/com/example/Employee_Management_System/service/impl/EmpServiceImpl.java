package com.example.Employee_Management_System.service.impl;

import com.example.Employee_Management_System.exception.IdNotFoundException;
import com.example.Employee_Management_System.model.Department;
import com.example.Employee_Management_System.model.Employee;
import com.example.Employee_Management_System.repository.DeptRepository;
import com.example.Employee_Management_System.repository.EmpRepository;
import com.example.Employee_Management_System.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    final EmpRepository empRepository;
    final DeptRepository deptRepository;

    @Autowired
    public EmpServiceImpl(EmpRepository empRepository, DeptRepository deptRepository){
        this.empRepository = empRepository;
        this.deptRepository = deptRepository;
    }


    public String addEmp(String fName, String lName, String email) {

        Employee employee = new Employee();
        employee.setFirstName(fName);
        employee.setLastName(lName);
        employee.setEmail(email);
        employee.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        employee.setUpdatedAt(null);

        empRepository.save(employee);

        return "Employee added successfully!!";

    }

    public Employee getEmp(Long id) throws IdNotFoundException{
        Optional<Employee> employeeOptional = empRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            return employee;
        }
        else{
            throw new IdNotFoundException("Invalid Id");
        }

    }

    public Employee updateEmail(Long id, String email) throws IdNotFoundException {
        Optional<Employee> employeeOptional = empRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setEmail(email);
            employee.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            empRepository.save(employee);
            return employee;
        }
        else{
            throw new IdNotFoundException("Invalid Id");
        }
    }

    public String deleteEmp(Long id) throws IdNotFoundException{
        Optional<Employee> employeeOptional = empRepository.findById(id);
        if(employeeOptional.isPresent()){
            empRepository.delete(employeeOptional.get());
        }
        else{
            throw new IdNotFoundException("Invalid Id");
        }
        return "Employee deleted successfully!!";
    }

}

