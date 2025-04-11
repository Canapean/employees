package ru.task.employees.adapter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.task.employees.domain.EmployeeEntity;
import ru.task.employees.domain.services.EmployeeServicempl;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServicempl employeeServicempl;

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(){
        return employeeServicempl.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee){
        EmployeeEntity createdEmployee = employeeServicempl.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id){
        EmployeeEntity employee = employeeServicempl.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<EmployeeEntity> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeEntity data){
        EmployeeEntity updatedEmployee = employeeServicempl.updateEmployeeById(id, data);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
        employeeServicempl.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
