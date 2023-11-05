package com.example.Employee_Management_System.controller;

import com.example.Employee_Management_System.model.Employee;
import com.example.Employee_Management_System.service.impl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmpController {
    final EmpServiceImpl empServiceImpl;
    @Autowired
    public EmpController(EmpServiceImpl empServiceImpl){
        this.empServiceImpl = empServiceImpl;
    }

    @PostMapping("/addEmp")
    public ResponseEntity addEmp(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email){
        String employeeResponse = empServiceImpl.addEmp(firstName, lastName, email);

        return new ResponseEntity(employeeResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getEmp/{id}")
    public ResponseEntity getEmp(@PathVariable Long id){
        try{
            Employee employee = empServiceImpl.getEmp(id);
            return new ResponseEntity<>(employee, HttpStatus.FOUND);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateEmail/{id}")
    public ResponseEntity updateEmail(@PathVariable Long id, @RequestParam String email) {
        try {
            Employee employee = empServiceImpl.updateEmail(id, email);
            return new ResponseEntity<>(employee, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

        @DeleteMapping("/deleteEmp/{id}")
        public ResponseEntity deleteEmp(@PathVariable Long id){
            try{
                String response = empServiceImpl.deleteEmp(id);
                return new ResponseEntity<>(response, HttpStatus.FOUND);
            }
            catch (Exception e){
                return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
    }

//    @PostMapping("/addEmpToDept")
//    public ResponseEntity addEmpDept(@RequestParam Long empId, @RequestParam String deptId){
//        try{
//            String response = empServiceImpl.addEmpDept(empId, deptId);
//            return new ResponseEntity<>(response, HttpStatus.FOUND);
//        }
//        catch (Exception e){
//            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }



}
