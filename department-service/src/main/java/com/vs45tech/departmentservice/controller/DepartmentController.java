package com.vs45tech.departmentservice.controller;

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

import com.vs45tech.departmentservice.model.Department;
import com.vs45tech.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);
   @Autowired
    private DepartmentRepository dRepository;

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        LOGGER.info("Department add: {}",department); 
return dRepository.addDepartment(department);
    }
    @GetMapping
    public List<Department> getAll(){
         LOGGER.info("Department find: {}"); 
        return dRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
         LOGGER.info("Department find: id={}",id); 
        return dRepository.findById(id);
    }
}
