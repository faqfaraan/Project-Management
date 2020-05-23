package com.faq.pma.services;

import com.faq.pma.dao.IProjectRepository;
import com.faq.pma.dto.ProjectCountDTO;
import com.faq.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    IProjectRepository proRepo;

    public Project save(Project project) {
        return proRepo.save(project);
    }

    public List<Project> getAll() {
        return proRepo.findAll();
    }

    public List<ProjectCountDTO> getProjectStatus() {
        return proRepo.getProjectStatus();
    }
}
