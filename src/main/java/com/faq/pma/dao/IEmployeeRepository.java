package com.faq.pma.dao;

import com.faq.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();
}
