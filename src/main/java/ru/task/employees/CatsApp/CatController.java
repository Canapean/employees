package ru.task.employees.CatsApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.task.employees.CatsApp.CatServicempl;

import java.util.List;

@RestController
@RequestMapping("api/cat")
public class CatController {

    @Autowired
    private CatServicempl catServicempl;

    @GetMapping
    public List<CatsDto> getAllEmployees(){
        return catServicempl.getAllCats();
    }

    @PostMapping
    public ResponseEntity<CatsDto> createEmployee(@RequestBody CatsDto employee){
        CatsDto createdEmployee = catServicempl.createCat(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatsDto> getEmployeeById(@PathVariable Long id){
        CatsDto employee = catServicempl.getCatById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CatsDto> updateEmployeeById(@PathVariable Long id, @RequestBody CatsDto data){
        CatsDto updatedEmployee = catServicempl.updateCatById(id, data);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
        catServicempl.deleteCatById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

