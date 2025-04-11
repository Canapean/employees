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
}
