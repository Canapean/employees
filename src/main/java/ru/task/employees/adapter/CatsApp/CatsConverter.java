package ru.task.employees.adapter.CatsApp;

import org.springframework.stereotype.Component;
import ru.task.employees.domain.CatsEntity;

@Component
public class CatsConverter {
    public CatsEntity toDto(CatModel model) {
        CatsEntity entity = new CatsEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setColor(model.getColor());
        return entity;
    }

    public CatModel toModel(CatsEntity entity) {
        CatModel model = new CatModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setColor(entity.getColor());
        return model;
    }
}
