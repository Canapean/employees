package ru.task.employees.CatsApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.task.employees.CatsApp.CatModel;

@Repository
public interface CatRepo extends JpaRepository<CatModel, Long> {
}
