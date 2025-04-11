package ru.task.employees.adapter.EmployeesApp;

import org.springframework.stereotype.Component;
import ru.task.employees.domain.EmployeeEntity;

@Component
public class EmployeeConverter {
    public EmployeeEntity toDto(EmployeeModel model) {
        EmployeeEntity dto = new EmployeeEntity();
        dto.setId(model.getId());
        dto.setFirst_name(model.getFirstName());
        dto.setLast_name(model.getLastName());
        dto.setCats(model.getCats());
        return dto;
    }

    public EmployeeModel toModel(EmployeeEntity dto) {
        EmployeeModel model = new EmployeeModel();
        model.setId(dto.getId());
        model.setFirstName(dto.getFirst_name());
        model.setLastName(dto.getLast_name());
        model.setCats(dto.getCats());
        return model;
    }
}
