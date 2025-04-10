package ru.task.employees.CatsApp;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private EmployeeModel employee;
}
