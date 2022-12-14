package com.nayabit.restfulems.service.impl;

import com.nayabit.restfulems.exception.ResourceNotFoundException;
import com.nayabit.restfulems.model.Employee;
import com.nayabit.restfulems.repository.EmployeeRepository;
import com.nayabit.restfulems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // we need to check whether employee with given id is exists in DB or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                                new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }
}
