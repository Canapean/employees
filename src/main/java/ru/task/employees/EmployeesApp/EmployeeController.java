package ru.task.employees.EmployeesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.task.employees.EmployeesApp.EmployeeServicempl;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServicempl employeeServicempl;

    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return employeeServicempl.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employee){
        EmployeeDto createdEmployee = employeeServicempl.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        EmployeeDto employee = employeeServicempl.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDto data){
        EmployeeDto updatedEmployee = employeeServicempl.updateEmployeeById(id, data);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
        employeeServicempl.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
