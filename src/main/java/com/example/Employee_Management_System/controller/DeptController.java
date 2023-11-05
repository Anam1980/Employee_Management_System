package com.example.Employee_Management_System.controller;

import com.example.Employee_Management_System.model.Department;
import com.example.Employee_Management_System.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DeptController {
    final DeptServiceImpl deptServiceImpl;

    @Autowired
    public DeptController(DeptServiceImpl deptServiceImpl){
        this.deptServiceImpl = deptServiceImpl;
    }

    @PostMapping("/addDept")
    public ResponseEntity addDept(@RequestParam String deptName){
        try{
            String response = deptServiceImpl.addDept(deptName);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getDept/id={id}")
    public ResponseEntity getDept(@PathVariable String id){
        try{
           Department response = deptServiceImpl.getDept(id);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateDept/id={id}")
    public ResponseEntity updateDept(@PathVariable String id){
        try{
            Department response = deptServiceImpl.updateDept(id);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteDept/id={id}")
    public ResponseEntity deleteDept(@PathVariable String id){
        try{
            String response = deptServiceImpl.deleteDept(id);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
