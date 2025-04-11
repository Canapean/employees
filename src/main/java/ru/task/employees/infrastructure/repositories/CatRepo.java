package ru.task.employees.infrastructure.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.task.employees.adapter.CatsApp.CatModel;

@Repository
public interface CatRepo extends JpaRepository<CatModel, Long> {
}
