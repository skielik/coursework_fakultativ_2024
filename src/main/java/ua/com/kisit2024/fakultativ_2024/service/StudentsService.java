package ua.com.kisit2024.fakultativ_2024.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit2024.fakultativ_2024.entity.Students;
import ua.com.kisit2024.fakultativ_2024.repository.StudentsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsService {
    private final StudentsRepository studentsRepository;

    public List<Students> findAllStudents(){
        return studentsRepository.findAll();
    }
}
