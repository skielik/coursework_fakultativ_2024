package ua.com.kisit2024.fakultativ_2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kisit2024.fakultativ_2024.service.StudentsService;

@Controller
public class StudentsController {
    private final StudentsService students;

    public StudentsController(StudentsService students){
        this.students = students;
    }

    @GetMapping("/students")
    public String getPageAllStudents(Model model){
        model.addAttribute("students", students.findAllStudents());
        return "students";
    }
}
