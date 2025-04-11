package ru.task.employees.domain.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.task.employees.adapter.CatsApp.CatModel;
import ru.task.employees.infrastructure.repositories.CatRepo;
import ru.task.employees.adapter.CatsApp.CatsConverter;
import ru.task.employees.domain.CatsEntity;
import ru.task.employees.domain.interfaces.CatService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatServicempl implements CatService {

    @Autowired
    private CatRepo catRepo;
    private final CatsConverter catsConverter;

    public CatServicempl(CatsConverter catsConverter){
        this.catsConverter = catsConverter;
    }

    @Override
    public List<CatsEntity> getAllCats(){
        List<CatModel> cats = catRepo.findAll();
        List<CatsEntity> result = new ArrayList<>();

        for (CatModel model : cats){
            result.add(catsConverter.toDto(model));
        }
        return result;
    }

    @Override
    public CatsEntity createCat(CatsEntity dto){
        CatModel cat = catsConverter.toModel(dto);
        CatModel savedModel = catRepo.save(cat);
        return catsConverter.toDto(savedModel);
    }

    @Override
    public CatsEntity getCatById(Long id){
        CatModel cat = catRepo.getById(id);
        return  catsConverter.toDto(cat);
    }

    @Override
    public CatsEntity updateCatById(Long id, CatsEntity newCat){
        CatModel cat = catRepo.getById(id);

        cat.setName(newCat.getName());
        cat.setColor(newCat.getColor());

        CatModel updatedCat = catRepo.save(cat);
        return catsConverter.toDto(updatedCat);
    }

    @Override
    public void deleteCatById(Long id){
        catRepo.deleteById(id);
    }
}
