package com.example.Employee_Management_System.service.impl;

import com.example.Employee_Management_System.exception.IdNotFoundException;
import com.example.Employee_Management_System.model.Department;
import com.example.Employee_Management_System.repository.DeptRepository;
import com.example.Employee_Management_System.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class DeptServiceImpl implements DeptService {

    final DeptRepository deptRepository;

    @Autowired
    public DeptServiceImpl(@Qualifier("DeptRepository") DeptRepository deptRepository){
        this.deptRepository = deptRepository;
    }

    public String addDept(String name) {
        Department department = new Department();
        department.setDepartmentName(name);
        department.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        department.setUpdatedAt(null);

        deptRepository.save(department);
        return "Department added successfully!!";
    }

    public Department getDept(String id) throws IdNotFoundException {
        Optional<Department> departmentOptional = deptRepository.findById(id);
        if(departmentOptional.isPresent()){
            Department department = departmentOptional.get();
            return department;
        }
        else{
            throw  new IdNotFoundException("Invalid Id");
        }
    }

    public Department updateDept(String id) throws IdNotFoundException {
        Optional<Department> departmentOptional = deptRepository.findById(id);
        if(departmentOptional.isPresent()){
            Department department = departmentOptional.get();
            department.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return department;
        }
        else{
            throw  new IdNotFoundException("Invalid Id");
        }
    }

    public String deleteDept(String id) throws IdNotFoundException {
       try{
           deptRepository.deleteById(id);
       }
        catch(Exception e){
            throw  new IdNotFoundException("Invalid Id");
        }
       return "Department deleted successfully!!";
    }
}
