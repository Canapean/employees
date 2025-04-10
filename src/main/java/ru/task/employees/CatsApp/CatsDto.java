package ru.task.employees.CatsApp;

import lombok.Data;
import ru.task.employees.EmployeesApp.EmployeeModel;

@Data
public class CatsDto {
    private Long id;
    private String name;
    private String color;
    private EmployeeModel employee;
}
