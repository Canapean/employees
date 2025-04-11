package ru.task.employees.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.task.employees.adapter.CatsApp.CatModel;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeEntity {
    private Long id;
    private String first_name;
    private String last_name;
    private List<CatModel> cats = List.of();
}
