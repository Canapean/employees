package ru.task.employees.EmployeesApp;

import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {
    public EmployeeDto toDto(EmployeeModel model) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setCats(model.getCats());
        return dto;
    }

    public EmployeeModel toModel(EmployeeDto dto) {
        EmployeeModel model = new EmployeeModel();
        model.setId(dto.getId());
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setCats(dto.getCats());
        return model;
    }
}
