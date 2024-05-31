package ua.com.kisit2024.fakultativ_2024.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit2024.fakultativ_2024.entity.Courses;
import ua.com.kisit2024.fakultativ_2024.entity.Teachers;
import ua.com.kisit2024.fakultativ_2024.repository.CoursesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesService {
    private final CoursesRepository coursesRepository;

    public List<Courses> findAllCourses(){
        return coursesRepository.findAll();
    }


}

