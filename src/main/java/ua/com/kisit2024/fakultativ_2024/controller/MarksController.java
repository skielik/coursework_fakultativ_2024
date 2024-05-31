package ua.com.kisit2024.fakultativ_2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kisit2024.fakultativ_2024.entity.StudentsHasCourses;
import ua.com.kisit2024.fakultativ_2024.service.StudentsHasCoursesService;

@Controller
public class MarksController {
    private final StudentsHasCoursesService studentsHasCoursesService;

    public MarksController(StudentsHasCoursesService studentsHasCoursesService){
        this.studentsHasCoursesService = studentsHasCoursesService;
    }

    @GetMapping("/marks")
    public String getPageAllMarks(Model model){
        model.addAttribute("marks", studentsHasCoursesService.findAllStudentsHasCourses());
        return "marks";
    }
}
