package ua.com.kisit2024.fakultativ_2024.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit2024.fakultativ_2024.entity.*;
import ua.com.kisit2024.fakultativ_2024.service.CoursesService;
import ua.com.kisit2024.fakultativ_2024.service.UserService;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/registration")
    public String getPageRegistration(){

        return "registration";
    }
    @GetMapping("/registrationStudents")
    public String getPageRegistrationStudents(Model model){
        model.addAttribute("users", new Users());
        model.addAttribute("students", new Students());

        return "registrationStudents";
    }
    @PostMapping("/registrationStudents")
    public String saveNewStudents_ToDb(@Valid Users user,
                                  BindingResult bindingResult1,
                                  @Valid Students student,
                                  BindingResult bindingResult2
    ){
        // Validation User
        if(bindingResult1.hasErrors()){
            return "registrationStudents";
        }

        // Validation Student
        if(bindingResult2.hasErrors()){
            return "registrationStudents";
        }

        // Username in DB
        if(userService.getLogicByUsername(user.getUsername())){
            return "redirect:/registrationStudents";
        }

        user.setRolesset(Collections.singleton(new Roles(2L, "Student")));
        // User (+id) = save User to DB
        Users user1 = userService.saveNewUserToDB(user);

        // Student setUser
        student.setUser(user1);

        //save Student
        userService.saveNewStudentsToDB(student);



        return "redirect:/courses";
    }
    @GetMapping("/registrationTeachers")
    public String getPageRegistrationTeachers(Model model){
        model.addAttribute("users", new Users());
        model.addAttribute("teachers", new Teachers());
        model.addAttribute("courses", new Courses());

        return "registrationTeachers";
    }
    @PostMapping("/registrationTeachers")
    public String saveNewTeachers_ToDb(@Valid Users user,
                                       BindingResult bindingResult1,
                                       @Valid Teachers teacher,
                                       BindingResult bindingResult2,
                                       @Valid Courses course,
                                       BindingResult bindingResult3
                                       ){
        // Validation User
        if(bindingResult1.hasErrors()){
            return "registrationTeachers";
        }

        // Validation Student
        if(bindingResult2.hasErrors()){
            return "registrationTeachers";
        }

        if(bindingResult3.hasErrors()){
            return "registrationTeachers";
        }

        // Username in DB
        if(userService.getLogicByUsername(user.getUsername())){
            return "redirect:/registrationTeachers";
        }

        user.setRolesset(Collections.singleton(new Roles(1L, "Teacher")));
        // User (+id) = save User to DB
        Users user1 = userService.saveNewUserToDB(user);

        // Student setUser
        teacher.setUser(user1);

        //save Student
        userService.saveNewTeacherToDB(teacher);

        course.setTeachers(teacher);
        userService.saveNewCourseToDB(course);



        return "redirect:/marks";
    }


    @GetMapping("/courses/{id}")
    public String getPageLoginStudent(@PathVariable long id, Model model){
        return "login";
    }
    @PostMapping("/courses/{id}")
    public String getAuth(@RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password,
                          @PathVariable long id,  @Valid StudentsHasCourses studentsHasCourses
    ) {

        if (userService.getLogicByUsernameAndPassword(username, password)) {

            return "redirect:/registration";}
        else {
            Users user1 = userService.getUserByUsername(username);
            Students student = userService.getStudentById(user1.getId());
            studentsHasCourses.set_students(student);
            Courses course = userService.getCourseById(id);
            studentsHasCourses.set_courses(course);

            StudentsHasCourses studentsHasCourses1 = userService.saveNewStudentsHasCourseToDB(studentsHasCourses);
            return "redirect:/courses";
        }
    }

    @GetMapping("/teacherLogin")
    public String getPageLoginTeacher(){
        return "login";
    }
    @PostMapping("/teacherLogin")
    public String getAuthTeacher(@RequestParam(name = "username") String username,
                                 @RequestParam(name = "password") String password,
                                 Model model){
        if (userService.getLogicByUsernameAndPassword(username, password)) {
            return "redirect:/registration";}
        else{
            Users user1 = userService.getUserByUsername(username);
            if(userService.getLogicTeacherById(user1.getId())){
                return "redirect:/registration";
            }
            else{
                Teachers teacher = userService.getTeacherById(user1.getId());
                Courses course = userService.getCourseByTeacher(teacher);
                List<StudentsHasCourses> studentsHasCourses = userService.findAllStudentsHasCoursesByCourse(course);
                model.addAttribute("course", course);
                model.addAttribute("studentHasCourses", studentsHasCourses);
                return "marksRate";
            }
        }
    }
}
