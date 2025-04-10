package ru.task.employees.EmployeesApp;
import org.springframework.stereotype.Repository;
import ru.task.employees.EmployeesApp.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel, Long>{
}
