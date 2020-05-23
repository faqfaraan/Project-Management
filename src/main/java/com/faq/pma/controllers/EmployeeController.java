package com.faq.pma.controllers;

import com.faq.pma.entities.Employee;
import com.faq.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empRepo;

	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = empRepo.getAll();
		model.addAttribute("employees", employees);

		return "employees/list-employees";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee anEmployee = new Employee();
		model.addAttribute("employee", anEmployee);
		
		return "employees/new-employee";
	}

	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		empRepo.save(employee);

		return "redirect:/employees/new";
	}
	
}
