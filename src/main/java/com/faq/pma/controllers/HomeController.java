package com.faq.pma.controllers;

import com.faq.pma.dao.IEmployeeRepository;
import com.faq.pma.dao.IProjectRepository;
import com.faq.pma.dto.EmployeeProjectDTO;
import com.faq.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IProjectRepository proRepo;

    @Autowired
    IEmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = proRepo.findAll();
        List<EmployeeProjectDTO> employeesProjectCount = empRepo.employeeProjects();

        model.addAttribute("projectList", projects);
        model.addAttribute("employeeListProjectsCount", employeesProjectCount);

        return "main/home";
    }
}
