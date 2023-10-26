package com.vs45tech.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vs45tech.employeeservice.model.Employee;
import com.vs45tech.employeeservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
     private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping
     public Employee addEmployee(@RequestBody Employee employee){
        LOGGER.info("Department add: {}",employee); 
return employeeRepository.addEmployee(employee);
    }
    @GetMapping
    public List<Employee> getAll(){
         LOGGER.info("Department find: {}"); 
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
         LOGGER.info("Employee find: id={}",id); 
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{deptId}")
    public List<Employee> findByDepartment(@PathVariable("deptId") Long deptId){
       return employeeRepository.findByDepartment(deptId); 
    }

}
