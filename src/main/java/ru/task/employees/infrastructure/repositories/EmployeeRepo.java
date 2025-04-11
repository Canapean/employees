package ru.task.employees.infrastructure.repositories;
import org.springframework.stereotype.Repository;
import ru.task.employees.adapter.EmployeesApp.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel, Long>{
}
