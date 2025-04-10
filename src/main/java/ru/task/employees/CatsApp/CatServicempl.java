package ru.task.employees.CatsApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.task.employees.CatsApp.CatService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatServicempl implements CatService{

    @Autowired
    private CatRepo catRepo;
    private CatsConverter catsConverter;

    @Override
    public List<CatsDto> getAllCats(){
        List<CatModel> cats = catRepo.findAll();
        List<CatsDto> result = new ArrayList<>();

        for (CatModel model : cats){
            result.add(catsConverter.toDto(model));
        }
        return result;
    }

    @Override
    public CatsDto createCat(CatsDto dto){
        CatModel cat = catsConverter.toModel(dto);
        CatModel savedModel = catRepo.save(cat);
        return catsConverter.toDto(savedModel);
    }

    @Override
    public CatsDto getCatById(Long id){
        CatModel cat = catRepo.getById(id);
        return  catsConverter.toDto(cat);
    }

    @Override
    public CatsDto updateCatById(Long id, CatsDto newCat){
        CatModel cat = catRepo.getById(id);

        cat.setName(newCat.getName());
        cat.setColor(newCat.getColor());
        cat.setEmployee(newCat.getEmployee());

        CatModel updatedCat = catRepo.save(cat);
        return catsConverter.toDto(updatedCat);
    }

    @Override
    public void deleteCatById(Long id){
        catRepo.deleteById(id);
    }
}
