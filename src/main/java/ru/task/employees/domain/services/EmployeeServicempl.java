package ru.task.employees.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.task.employees.adapter.CatsApp.CatModel;
import ru.task.employees.infrastructure.repositories.CatRepo;
import ru.task.employees.adapter.EmployeesApp.EmployeeConverter;
import ru.task.employees.adapter.EmployeesApp.EmployeeModel;
import ru.task.employees.infrastructure.repositories.EmployeeRepo;
import ru.task.employees.domain.EmployeeEntity;
import ru.task.employees.domain.interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServicempl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CatRepo catRepo;

    private final EmployeeConverter employeeConverter;

    public EmployeeServicempl(EmployeeConverter employeeConverter) {
        this.employeeConverter = employeeConverter;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees(){
        List<EmployeeModel> employees = employeeRepo.findAll();
        List<EmployeeEntity> result = new ArrayList<>();
        for (EmployeeModel model : employees){
            result.add(employeeConverter.toDto(model));
        }
        return result;
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity dto){
        EmployeeModel model = employeeConverter.toModel(dto);
        EmployeeModel savedModel = employeeRepo.save(model);
        return employeeConverter.toDto(savedModel);
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id){
        EmployeeModel model = employeeRepo.getById(id);
        return employeeConverter.toDto(model);
    }

    @Override
    public EmployeeEntity updateEmployeeById(Long id, EmployeeEntity data){
        EmployeeModel employee = employeeRepo.getById(id);

        employee.setFirstName(data.getFirst_name());
        employee.setLastName(data.getLast_name());

        if (data.getCats() != null) {
            employee.getCats().clear();

            List<CatModel> newCats = catRepo.findAllById(
                    data.getCats().stream()
                            .map(CatModel::getId)
                            .collect(Collectors.toList())
            );

            newCats.forEach(cat -> cat.setEmployee(employee));
            employee.setCats(newCats);
        } else {
            employee.getCats().clear();
        }

        EmployeeModel updatedEmployee = employeeRepo.save(employee);
        return employeeConverter.toDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id){
        employeeRepo.deleteById(id);
    }
}
