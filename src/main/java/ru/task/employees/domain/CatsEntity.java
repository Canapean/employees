package ru.task.employees.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.task.employees.adapter.EmployeesApp.EmployeeModel;

@AllArgsConstructor
@NoArgsConstructor
public class CatsEntity {
    private Long id;
    private String name;
    private String color;
    private EmployeeModel employee = null;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public EmployeeModel getEmployee() {
        return this.employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEmployee(EmployeeModel employee) {
        this.employee = employee;
    }
}
