package com.campusconnect.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Student;
import com.campusconnect.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;




@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student registerStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
        	throw new ResponseStatusException(
        		    HttpStatus.CONFLICT,
        		    "Email address is already registered"
        		);
        }
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public List<Student> getStudentsByDepartment(String department) {
    	return studentRepository.findByDepartmentIgnoreCase(department);
    }
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with email: " + email
                ));
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with id: " + id
                ));
    }
    public List<Student> getStudentsByGraduationYear(Integer graduationYear) {
        return studentRepository.findByGraduationYear(graduationYear);
    }
    public List<Student> getStudentsByStatus(String status) {
        return studentRepository.findByStatusIgnoreCase(status);
    }
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with ID: " + id
                ));
        
        Optional<Student> studentWithSameEmail =
                studentRepository.findByEmailIgnoreCase(updatedStudent.getEmail());

        if (studentWithSameEmail.isPresent() &&
                !studentWithSameEmail.get().getId().equals(id)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email address is already registered"
            );
        }

        
        existingStudent.setFullName(updatedStudent.getFullName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setPhone(updatedStudent.getPhone());
        existingStudent.setDepartment(updatedStudent.getDepartment());
        existingStudent.setGraduationYear(updatedStudent.getGraduationYear());
        existingStudent.setStatus(updatedStudent.getStatus());
        existingStudent.setPassword(updatedStudent.getPassword());
        return studentRepository.save(existingStudent);
        
    }
    
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with ID: " + id
                ));

        studentRepository.delete(student);
    }
    
}