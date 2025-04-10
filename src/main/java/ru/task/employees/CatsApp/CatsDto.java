package ru.task.employees.CatsApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.task.employees.EmployeesApp.EmployeeModel;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CatsDto {
    private Long id;
    private String name;
    private String color;
    private EmployeeModel employee = null;
}
