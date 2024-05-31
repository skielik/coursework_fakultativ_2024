package ua.com.kisit2024.fakultativ_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit2024.fakultativ_2024.entity.Courses;
import ua.com.kisit2024.fakultativ_2024.entity.Students;
import ua.com.kisit2024.fakultativ_2024.entity.StudentsHasCourses;
import ua.com.kisit2024.fakultativ_2024.entity.Users;

import java.util.List;

public interface StudentsHasCoursesRepository extends JpaRepository<StudentsHasCourses, Long> {
    List<StudentsHasCourses> findAllBy_courses(Courses courses);
    StudentsHasCourses findAllById(Long id);
}
