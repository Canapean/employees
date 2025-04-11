package ru.task.employees.domain.interfaces;

import org.springframework.stereotype.Service;
import ru.task.employees.domain.EmployeeEntity;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity createEmployee(EmployeeEntity employee);
    EmployeeEntity getEmployeeById(Long id);
    EmployeeEntity updateEmployeeById(Long id, EmployeeEntity data);
    void deleteEmployeeById(Long id);
}
