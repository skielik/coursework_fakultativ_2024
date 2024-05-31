package ua.com.kisit2024.fakultativ_2024.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit2024.fakultativ_2024.entity.*;
import ua.com.kisit2024.fakultativ_2024.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;

    private final StudentsRepository studentsRepository;
    private final TeachersRepository teachersRepository;
    private final CoursesRepository coursesRepository;
    private final StudentsHasCoursesRepository studentsHasCoursesRepository;
    public boolean getLogicByUsername(String username){
        return (!usersRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }

    public Users saveNewUserToDB(Users user){
        return  usersRepository.save(user);
    }

    public Students saveNewStudentsToDB(Students student){
        return studentsRepository.save(student);
    }

    public Teachers saveNewTeacherToDB(Teachers teacher){ return teachersRepository.save(teacher); }

    public Courses saveNewCourseToDB(Courses course){ return coursesRepository.save(course); }

    public StudentsHasCourses saveNewStudentsHasCourseToDB(StudentsHasCourses studentsHasCourses){
        return studentsHasCoursesRepository.save(studentsHasCourses); }

    public boolean getLogicByUsernameAndPassword(String username, String password) {
        return (usersRepository.findAllByUsernameAndPassword(username, password).isEmpty());

    }
    public boolean getLogicTeacherById(long id) {
        return (teachersRepository.findAllById(id).isEmpty());
    }



    public Users getUserByUsername(String username) {
        return usersRepository.findAllByUsername(username).get(0);
    }

    public Students getStudentById(Long student_id) {
        return studentsRepository.findAllById(student_id).get(0);
    }

    public Courses getCourseById(Long course_id) {
        return coursesRepository.findAllById(course_id).get(0);
    }
    public Courses getCourseByTeacher(Teachers teacher){return coursesRepository.findAllByTeachers(teacher).get(0);}
    public Teachers getTeacherById(Long id){return  teachersRepository.findAllById(id).get(0);}
    public List<StudentsHasCourses> findAllStudentsHasCoursesByCourse(Courses course){return  studentsHasCoursesRepository.findAllBy_courses(course);}

}
