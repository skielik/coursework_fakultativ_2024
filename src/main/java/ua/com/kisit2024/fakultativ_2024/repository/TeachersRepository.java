package ua.com.kisit2024.fakultativ_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit2024.fakultativ_2024.entity.Teachers;

import java.util.List;

public interface TeachersRepository extends JpaRepository<Teachers, Long> {
    List<Teachers> findAllById(Long id);
}
