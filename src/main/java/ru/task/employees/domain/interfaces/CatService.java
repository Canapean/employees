package ru.task.employees.domain.interfaces;

import ru.task.employees.domain.CatsEntity;

import java.util.List;

public interface CatService {
    List<CatsEntity> getAllCats();
    CatsEntity createCat(CatsEntity cat);
    CatsEntity getCatById(Long id);
    CatsEntity updateCatById(Long id, CatsEntity newCat);
    void deleteCatById(Long id);
}
