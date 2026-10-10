package com.campusconnect.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.campusconnect.entity.Student;
import java.util.List;
public interface StudentRepository extends JpaRepository<Student, Long> {

	boolean existsByEmail(String email);
	Optional<Student> findByEmailIgnoreCase(String email);
	List<Student> findByDepartmentIgnoreCase(String department);
	List<Student> findByGraduationYear(Integer graduationYear);
	List<Student> findByStatusIgnoreCase(String status);
	Student findByEmail(String email);
}