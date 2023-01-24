package com.company.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.crud.model.Employee;
import com.company.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> search(String string) {
		return employeeRepository.findByNameContaining(string);
	}

	@Override
	public Optional<Employee> findOne(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void save(Employee contact) {
		employeeRepository.save(contact);
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

}
