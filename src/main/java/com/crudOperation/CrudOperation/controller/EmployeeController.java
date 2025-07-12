package com.crudOperation.CrudOperation.controller;

import com.crudOperation.CrudOperation.model.Employee;
import com.crudOperation.CrudOperation.services.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable String id){
        return employeeService.getById(id);
    }

    @GetMapping("/name/{name}")
    public Employee findname(@PathVariable String name){
        return employeeService.findByName(name);
    }
    @PostMapping("/insert")
    public List<Employee> insertData(@RequestBody List<Employee> employees){
        return employeeService.insertName(employees);
    }
    @PostMapping("/write")
    public String byName(@RequestBody Employee employee){
        return employeeService.byName(employee);
    }
    @PutMapping("/update/{id}/{name}")
    public String update(@PathVariable String id , @PathVariable String name, @RequestBody Employee updatedData){
        return employeeService.update(id, name, updatedData);
    }


}
