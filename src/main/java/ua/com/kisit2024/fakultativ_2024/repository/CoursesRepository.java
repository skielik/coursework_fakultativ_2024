package ua.com.kisit2024.fakultativ_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit2024.fakultativ_2024.entity.Courses;
import ua.com.kisit2024.fakultativ_2024.entity.Teachers;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
   List<Courses> findAllById(Long id);
   List<Courses> findAllByTeachers(Teachers teacher);
}
