package ru.task.employees.CatsApp;

import org.springframework.stereotype.Component;
import ru.task.employees.EmployeesApp.EmployeeDto;
import ru.task.employees.EmployeesApp.EmployeeModel;

@Component
public class CatsConverter {
    public CatsDto toDto(CatModel model) {
        CatsDto dto = new CatsDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setColor(model.getColor());
        dto.setEmployee(model.getEmployee());
        return dto;
    }

    public CatModel toModel(CatsDto dto) {
        CatModel model = new CatModel();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setColor(dto.getColor());
        model.setEmployee(dto.getEmployee());
        return model;
    }
}
