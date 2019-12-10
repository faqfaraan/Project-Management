package com.faq.pma.controllers;

import com.faq.pma.dao.IEmployeeRepository;
import com.faq.pma.dao.IProjectRepository;
import com.faq.pma.entities.Employee;
import com.faq.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectRepository proRepo;

	@Autowired
	IEmployeeRepository empRepo;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectList", projects);

		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();

		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aProject);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		proRepo.save(project);

		Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);

		for(Employee emp : chosenEmployees) {
			emp.setProject(project);
			empRepo.save(emp);
		}

		// use a redirect to prevent duplicate submissions
		return "redirect:/projects/new";
	}
	
}
