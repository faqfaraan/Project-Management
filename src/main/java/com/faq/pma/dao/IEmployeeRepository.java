package com.faq.pma.dao;

import com.faq.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
}
