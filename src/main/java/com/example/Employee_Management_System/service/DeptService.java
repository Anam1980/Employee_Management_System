package com.example.Employee_Management_System.service;

import com.example.Employee_Management_System.exception.IdNotFoundException;
import com.example.Employee_Management_System.model.Department;

public interface DeptService {
    public String addDept(String name);
    public Department getDept(String id) throws IdNotFoundException;
    public Department updateDept(String id) throws IdNotFoundException;
    public String deleteDept(String id) throws IdNotFoundException;
}
