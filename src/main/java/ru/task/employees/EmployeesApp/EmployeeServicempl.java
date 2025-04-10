package ru.task.employees.EmployeesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.task.employees.CatsApp.CatModel;
import ru.task.employees.CatsApp.CatRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServicempl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CatRepo catRepo;

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
