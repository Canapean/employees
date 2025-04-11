package ru.task.employees.adapter.CatsApp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import ru.task.employees.adapter.EmployeesApp.EmployeeModel;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cats")
public class CatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private EmployeeModel employee;

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
