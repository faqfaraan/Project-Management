package com.faq.pma.dao;

import com.faq.pma.dto.ProjectCountDTO;
import com.faq.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage AS label, COUNT(*) AS value FROM project GROUP BY stage")
    public List<ProjectCountDTO> getProjectStatus();

}
