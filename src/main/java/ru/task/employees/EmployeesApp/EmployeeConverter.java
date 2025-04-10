package ru.task.employees.EmployeesApp;

import org.springframework.stereotype.Component;
import ru.task.employees.EmployeesApp.EmployeeDto;
import ru.task.employees.EmployeesApp.EmployeeModel;

@Component
public class EmployeeConverter {
    public EmployeeDto toDto(EmployeeModel model) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(model.getId());
        dto.setFirst_name(model.getFirstName());
        dto.setLast_name(model.getLastName());
        dto.setCats(model.getCats());
        return dto;
    }

    public EmployeeModel toModel(EmployeeDto dto) {
        EmployeeModel model = new EmployeeModel();
        model.setId(dto.getId());
        model.setFirstName(dto.getFirst_name());
        model.setLastName(dto.getLast_name());
        model.setCats(dto.getCats());
        return model;
    }
}
