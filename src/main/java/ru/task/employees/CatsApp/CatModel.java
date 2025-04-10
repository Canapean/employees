package ru.task.employees.CatsApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.task.employees.EmployeesApp.EmployeeModel;

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
    private EmployeeModel employee;
}
