package com.campusconnect.controller;

import com.campusconnect.dto.LoginRequest;
import com.campusconnect.dto.LoginResponse;
import com.campusconnect.entity.Student;
import com.campusconnect.repository.StudentRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {

    private final StudentRepository studentRepository;

    public LoginController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Student student =
                studentRepository.findByEmail(request.getEmail());

        if (student == null) {
            return ResponseEntity
                    .status(401)
                    .body("Invalid email or password");
        }

        if (!student.getPassword().equals(request.getPassword())) {
            return ResponseEntity
                    .status(401)
                    .body("Invalid email or password");
        }

        // Do not send password to the frontend
        LoginResponse response = new LoginResponse(
                student.getId(),
                student.getFullName(),
                student.getEmail(),
                student.getPhone(),
                student.getDepartment(),
                student.getGraduationYear(),
                student.getStatus()
        );

        return ResponseEntity.ok(response);
    }
}