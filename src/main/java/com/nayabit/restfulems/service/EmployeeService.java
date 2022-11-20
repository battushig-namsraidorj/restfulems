package com.nayabit.restfulems.service;

import com.nayabit.restfulems.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();
}
