package com.example.Employee_Management_System.service;

import com.example.Employee_Management_System.exception.IdNotFoundException;
import com.example.Employee_Management_System.model.Employee;

public interface EmpService {
    public String addEmp(String fName, String lName, String email);
    public Employee getEmp(Long id) throws IdNotFoundException;
    public Employee updateEmail(Long id, String email) throws IdNotFoundException;
    public String deleteEmp(Long id) throws IdNotFoundException;
    //public String addEmpDept(Long empId, String deptId) throws IdNotFoundException;
}
