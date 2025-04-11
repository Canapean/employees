package ru.task.employees.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.task.employees.adapter.CatsApp.CatModel;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    private Long id;
    private String first_name;
    private String last_name;
    private List<CatModel> cats = List.of();

    public Long getId() {
        return this.id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public List<CatModel> getCats() {
        return this.cats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCats(List<CatModel> cats) {
        this.cats = cats;
    }
}
