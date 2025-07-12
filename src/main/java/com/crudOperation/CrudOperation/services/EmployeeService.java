package com.crudOperation.CrudOperation.services;

import com.crudOperation.CrudOperation.model.Employee;
import com.crudOperation.CrudOperation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getById(@PathVariable String id){
        return employeeRepository.findById(id);
    }

    public Employee findByName(@PathVariable String name){
        return employeeRepository.findByName(name);
    }

    public List<Employee> insertName(List<Employee> employees){
        List<Employee> filtered =  new ArrayList<>();
        for(Employee emp :employees){
            if(emp.getId() == null){
              emp.setId(UUID.randomUUID().toString());
              filtered.add(emp);
            }

        }
        return employeeRepository.saveAll(filtered);
    }

    public String byName(Employee employee){
        if(employee.getId() == null){
            employee.setId(UUID.randomUUID().toString());
            employeeRepository.save(employee);
        }
        return "Data inserted Succsfully";
    }
    public String update(String id, String name, Employee updatedData) {
        Employee employee = employeeRepository.getByIdAndName(id, name);

        if (employee != null) {
            // Dynamically update only non-null fields
            if (updatedData.getAddress() != null) {
                employee.setAddress(updatedData.getAddress());
            }
            if (updatedData.getPhone() != null) {
                employee.setPhone(updatedData.getPhone());
            }
            if (updatedData.getEmail() != null) {
                employee.setEmail(updatedData.getEmail());
            }

            employeeRepository.save(employee);
            return "Data is updated Successfully";
        } else {
            return "Employee not found with given ID and Name.";
        }
    }

}
