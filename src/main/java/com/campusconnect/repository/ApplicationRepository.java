package com.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.campusconnect.entity.Application;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    boolean existsByStudentIdAndJobId(Long studentId, Long jobId);

    List<Application> findByStudentId(Long studentId);

}