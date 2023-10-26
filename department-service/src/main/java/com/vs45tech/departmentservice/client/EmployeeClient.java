package com.vs45tech.departmentservice.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

import com.vs45tech.departmentservice.model.Employee;

@HttpExchange
public interface EmployeeClient {
    
     @GetMapping("/employee/department/{deptId}")
    public List<Employee> findByDepartment(@PathVariable("deptId") Long deptId);
}
