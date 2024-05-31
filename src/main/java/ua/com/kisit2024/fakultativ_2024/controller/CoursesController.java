package ua.com.kisit2024.fakultativ_2024.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.kisit2024.fakultativ_2024.entity.Courses;
import ua.com.kisit2024.fakultativ_2024.service.CoursesService;

@Controller
public class CoursesController {
    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService){
        this.coursesService = coursesService;
    }

    @GetMapping("/courses")
    public String getPageAllCourses(Model model){
        model.addAttribute("courses", coursesService.findAllCourses());
        return "courses";
    }

}
