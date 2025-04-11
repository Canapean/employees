package ru.task.employees.adapter.EmployeesApp;

import org.springframework.stereotype.Component;
import ru.task.employees.domain.EmployeeEntity;

@Component
public class EmployeeConverter {
    public EmployeeEntity toDto(EmployeeModel model) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(model.getId());
        entity.setFirst_name(model.getFirstName());
        entity.setLast_name(model.getLastName());
        entity.setCats(model.getCats());
        return entity;
    }

    public EmployeeModel toModel(EmployeeEntity entity) {
        EmployeeModel model = new EmployeeModel();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirst_name());
        model.setLastName(entity.getLast_name());
        model.setCats(entity.getCats());
        return model;
    }
}
