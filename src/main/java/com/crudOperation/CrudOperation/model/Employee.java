package com.crudOperation.CrudOperation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    public String id;
    public String address;
    public String email;
    public String name;
    public String phone;

}
