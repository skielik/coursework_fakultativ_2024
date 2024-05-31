package ua.com.kisit2024.fakultativ_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit2024.fakultativ_2024.entity.Students;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {
    List<Students> findAllById(Long id);
}
