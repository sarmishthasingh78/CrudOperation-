package com.crudOperation.CrudOperation.repository;

import com.crudOperation.CrudOperation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
     Employee findByName(String name);
     Employee getByIdAndName(String id, String name);
}
