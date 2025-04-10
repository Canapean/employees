package ru.task.employees.EmployeesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServicempl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;
    private final EmployeeConverter employeeConverter;

    public EmployeeServicempl(EmployeeConverter employeeConverter) {
        this.employeeConverter = employeeConverter;
    }

    @Override
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeModel> employees = employeeRepo.findAll();
        List<EmployeeDto> result = new ArrayList<>();
        for (EmployeeModel model : employees){
            result.add(employeeConverter.toDto(model));
        }
        return result;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto){
        EmployeeModel model = employeeConverter.toModel(dto);
        EmployeeModel savedModel = employeeRepo.save(model);
        return employeeConverter.toDto(savedModel);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id){
        EmployeeModel model = employeeRepo.getById(id);
        return employeeConverter.toDto(model);
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto data){
        EmployeeModel employee = employeeRepo.getById(id);

        employee.setFirstName(data.getFirst_name());
        employee.setLastName(data.getLast_name());
        employee.setCats(data.getCats());

        EmployeeModel updatedEmployee = employeeRepo.save(employee);
        return employeeConverter.toDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id){
        employeeRepo.deleteById(id);
    }
}
