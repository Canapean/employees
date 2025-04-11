package ru.task.employees.adapter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.task.employees.domain.CatsEntity;
import ru.task.employees.domain.services.CatServicempl;

import java.util.List;

@RestController
@RequestMapping("api/cat")
public class CatController {

    @Autowired
    private CatServicempl catServicempl;

    @GetMapping
    public List<CatsEntity> getAllEmployees(){
        return catServicempl.getAllCats();
    }

    @PostMapping
    public ResponseEntity<CatsEntity> createEmployee(@RequestBody CatsEntity employee){
        CatsEntity createdEmployee = catServicempl.createCat(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatsEntity> getEmployeeById(@PathVariable Long id){
        CatsEntity employee = catServicempl.getCatById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CatsEntity> updateEmployeeById(@PathVariable Long id, @RequestBody CatsEntity data){
        CatsEntity updatedEmployee = catServicempl.updateCatById(id, data);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
        catServicempl.deleteCatById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

