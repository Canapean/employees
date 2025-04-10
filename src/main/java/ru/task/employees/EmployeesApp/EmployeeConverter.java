package ru.task.employees.EmployeesApp;

import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {
    public EmployeeDto toDto(EmployeeModel entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setCats(entity.getCats());
        return dto;
    }

    public EmployeeModel toEntity(EmployeeDto dto) {
        EmployeeModel entity = new EmployeeModel();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setCats(dto.getCats());
        return entity;
    }
}
