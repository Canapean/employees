package ru.task.employees.EmployeesApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.task.employees.CatsApp.CatModel;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private Long id;
    private String first_name;
    private String last_name;
    private List<CatModel> cats = List.of();
}
