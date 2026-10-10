package com.campusconnect.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusconnect.entity.Student;
import com.campusconnect.service.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Map;
import java.util.HashMap;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student registerStudent(@Valid @RequestBody Student student) {
        return studentService.registerStudent(student);
    }
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/search")
    public List<Student> getStudentsByDepartment(
            @RequestParam String department) {

        return studentService.getStudentsByDepartment(department);
    }
    @GetMapping("/search/email")
    public Student getStudentByEmail(@RequestParam String email) {
        return studentService.getStudentByEmail(email);
    }
    @GetMapping("/search/year")
    public List<Student> getStudentsByGraduationYear(
    		@RequestParam @Min(2020) Integer graduationYear) {

        return studentService.getStudentsByGraduationYear(graduationYear);
    }
    @GetMapping("/search/status")
    public List<Student> getStudentsByStatus(@RequestParam String status) {

        return studentService.getStudentsByStatus(status);
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("message", "Student deleted successfully");

        return response;
    }
}