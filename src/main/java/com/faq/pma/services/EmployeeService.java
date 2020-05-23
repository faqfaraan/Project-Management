package com.faq.pma.services;

import com.faq.pma.dao.IEmployeeRepository;
import com.faq.pma.dto.EmployeeProjectDTO;
import com.faq.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository empRepo;

    public Employee save(Employee employee) {
        return empRepo.save(employee);
    }

    public List<Employee> getAll() {
        return empRepo.findAll();
    }

    public List<EmployeeProjectDTO> employeeProjects() {
        return empRepo.employeeProjects();
    }
}
