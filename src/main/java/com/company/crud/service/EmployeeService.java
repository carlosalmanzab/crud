package com.company.crud.service;

import java.util.List;
import java.util.Optional;

import com.company.crud.model.Employee;

public interface EmployeeService {
	
	Iterable<Employee> findAll();
	
	List<Employee> search(String string);
	
	Optional<Employee> findOne(Long id);
	
	void save(Employee contact);
	
	void delete(Long id);
	
	
}
