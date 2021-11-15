package io.artur.spring.securitydemo.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            Student.builder().id(1L).name("Michael").build(),
            Student.builder().id(2L).name("Larry").build(),
            Student.builder().id(3L).name("Dominic").build()
    );

    @GetMapping
    public List<Student> getStudents() {
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("Registering student: " +student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        System.out.println("Deleting student with ID: " + studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        System.out.println("Updating student with ID: " + studentId + " Student: " + student);
    }
}
