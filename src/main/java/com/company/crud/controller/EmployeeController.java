package com.company.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.company.crud.model.Employee;
import com.company.crud.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public String index(Model model) {
		model.addAttribute("employees",employeeService.findAll());
		return "list";
	}
	
	@GetMapping("/employee/create")
	public String create(Model model) {
		model.addAttribute("employee", new Employee());
		return "form";
	}
	
	@PostMapping("/employee/save")
	public String save(@Valid Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	@GetMapping("employee/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("employee",employeeService.findOne(id));
		return "form";
	}
	
	@GetMapping("employee/{id}/delete")
	public String delete(@PathVariable Long id, Model model) {
		employeeService.delete(id);
		return "redirect:/employee";
	}
}
