package ru.task.employees.CatsApp;

import org.springframework.stereotype.Component;
import ru.task.employees.EmployeesApp.EmployeeDto;
import ru.task.employees.EmployeesApp.EmployeeModel;

@Component
public class CatsConverter {
    public CatsDto toDto(CatModel entity) {
        CatsDto dto = new CatsDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setColor(entity.getColor());
        dto.setEmployee(entity.getEmployee());
        return dto;
    }

    public CatModel toEntity(CatsDto dto) {
        CatModel entity = new CatModel();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setColor(dto.getColor());
        entity.setEmployee(dto.getEmployee());
        return entity;
    }
}
