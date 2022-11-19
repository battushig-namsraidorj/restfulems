package com.nayabit.restfulems.service.impl;

import com.nayabit.restfulems.model.Employee;
import com.nayabit.restfulems.repository.EmployeeRepository;
import com.nayabit.restfulems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
