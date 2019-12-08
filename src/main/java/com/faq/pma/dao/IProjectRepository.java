package com.faq.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.faq.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {

}
