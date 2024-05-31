package ua.com.kisit2024.fakultativ_2024.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit2024.fakultativ_2024.entity.StudentsHasCourses;
import ua.com.kisit2024.fakultativ_2024.service.StudentsHasCoursesService;


@Controller
@RequiredArgsConstructor
public class MarksRateController {

    private final StudentsHasCoursesService studentsHasCoursesService;
    @GetMapping("/submitMarks/{id}")
    public String getStudentMarkPage(@PathVariable long id,
                                     Model model){
        StudentsHasCourses studentsHasCourses = studentsHasCoursesService.getStudentsHasCoursesById(id);
        model.addAttribute("studentsHasCourses", studentsHasCourses);
        return "studentMark";
    }
    @PostMapping("/submitMarks/{id}")
    public String changeStudentMark(@PathVariable long id,
                                    @RequestParam(name = "mark") String mark){
        StudentsHasCourses studentsHasCourses = studentsHasCoursesService.getStudentsHasCoursesById(id);
        StudentsHasCourses newStudentsHasCourses = studentsHasCoursesService.getStudentsHasCoursesById(id);
        newStudentsHasCourses.setMark(Integer.parseInt(mark));
        studentsHasCoursesService.saveMarkStudent(studentsHasCourses, newStudentsHasCourses);
        return "redirect:/marks";
    }


}
