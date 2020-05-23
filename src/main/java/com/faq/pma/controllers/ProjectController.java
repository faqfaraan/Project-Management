package com.faq.pma.controllers;

import com.faq.pma.entities.Employee;
import com.faq.pma.entities.Project;
import com.faq.pma.services.EmployeeService;
import com.faq.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proRepo;

	@Autowired
	EmployeeService empRepo;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proRepo.getAll();
		model.addAttribute("projectList", projects);

		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employees = empRepo.getAll();

		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aProject);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proRepo.save(project);

		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
	
}
