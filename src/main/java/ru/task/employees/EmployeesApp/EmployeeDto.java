package ru.task.employees.EmployeesApp;

import lombok.Data;
import ru.task.employees.CatsApp.CatModel;

import java.util.Set;

@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<CatModel> cats;
}
