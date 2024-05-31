package ua.com.kisit2024.fakultativ_2024.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit2024.fakultativ_2024.entity.StudentsHasCourses;
import ua.com.kisit2024.fakultativ_2024.repository.StudentsHasCoursesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsHasCoursesService {
    private  final StudentsHasCoursesRepository studentsHasCoursesRepository;
    public List<StudentsHasCourses> findAllStudentsHasCourses() {return studentsHasCoursesRepository.findAll();}
    public StudentsHasCourses getStudentsHasCoursesById(Long id){return studentsHasCoursesRepository.findAllById(id);}

    public void saveMarkStudent(StudentsHasCourses studentsHasCourses, StudentsHasCourses newStudentsHasCourses){studentsHasCoursesRepository.delete(studentsHasCourses);
        studentsHasCoursesRepository.save(newStudentsHasCourses);}
}
