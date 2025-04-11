package ru.task.employees.adapter.CatsApp;

import org.springframework.stereotype.Component;
import ru.task.employees.domain.CatsEntity;

@Component
public class CatsConverter {
    public CatsEntity toDto(CatModel model) {
        CatsEntity dto = new CatsEntity();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setColor(model.getColor());
        return dto;
    }

    public CatModel toModel(CatsEntity dto) {
        CatModel model = new CatModel();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setColor(dto.getColor());
        return model;
    }
}
