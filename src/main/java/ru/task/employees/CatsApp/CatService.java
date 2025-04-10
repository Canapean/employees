package ru.task.employees.CatsApp;

import java.util.List;

public interface CatService {
    List<CatsDto> getAllCats();
    CatsDto createCat(CatsDto cat);
    CatsDto getCatById(Long id);
    CatsDto updateCatById(Long id, CatsDto newCat);
    void deleteCatById(Long id);
}
