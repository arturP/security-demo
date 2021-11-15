package io.artur.spring.securitydemo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            Student.builder().id(1L).name("Michael").build(),
            Student.builder().id(2L).name("Larry").build(),
            Student.builder().id(3L).name("Dominic").build()
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return STUDENTS.stream()
                .filter(s -> s.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find such student with id: " + studentId));
    }
}
