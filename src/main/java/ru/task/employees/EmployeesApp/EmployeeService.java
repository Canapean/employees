package ru.task.employees.EmployeesApp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto createEmployee(EmployeeDto employee);
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto updateEmployeeById(Long id, EmployeeDto data);
    void deleteEmployeeById(Long id);
}
