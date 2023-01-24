package com.company.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.company.crud.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	List<Employee> findByNameContaining(String name);
}
