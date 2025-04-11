package ru.task.employees.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.task.employees.adapter.EmployeesApp.EmployeeModel;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CatsEntity {
    private Long id;
    private String name;
    private String color;
    private EmployeeModel employee = null;
}
