package com.faq.pma.controllers;

import com.faq.pma.dao.IEmployeeRepository;
import com.faq.pma.dao.IProjectRepository;
import com.faq.pma.dto.EmployeeProjectDTO;
import com.faq.pma.dto.ProjectCountDTO;
import com.faq.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${version}")
    private String version;

    @Autowired
    IProjectRepository proRepo;

    @Autowired
    IEmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        model.addAttribute("versionNumber", version);

        Map<String, Object> map = new HashMap<>();

        List<Project> projects = proRepo.findAll();
        model.addAttribute("projectList", projects);

        List<EmployeeProjectDTO> employeesProjectCount = empRepo.employeeProjects();
        model.addAttribute("employeeListProjectsCount", employeesProjectCount);

        List<ProjectCountDTO> projectCount = proRepo.getProjectStatus();
        // Convert projectData object to json for javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectCount);
        model.addAttribute("projectStatusCount", jsonString);

        return "main/home";
    }
}
