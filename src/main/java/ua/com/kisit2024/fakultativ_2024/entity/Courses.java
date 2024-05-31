package ua.com.kisit2024.fakultativ_2024.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 4, message = "Course name must be longer than 4 characters")
    @Column(name = "course_name")
    private String courseName;

    @OneToOne
    private Teachers teachers;

    @OneToMany(mappedBy = "_courses")
    private List<StudentsHasCourses> studentsHasCourses;
}
