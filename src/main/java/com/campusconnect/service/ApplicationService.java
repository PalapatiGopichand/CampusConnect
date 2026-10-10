package com.campusconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campusconnect.entity.Application;
import com.campusconnect.repository.ApplicationRepository;
import com.campusconnect.repository.JobRepository;
import com.campusconnect.repository.StudentRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final JobRepository jobRepository;

    public ApplicationService(
            ApplicationRepository applicationRepository,
            StudentRepository studentRepository,
            JobRepository jobRepository) {

        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.jobRepository = jobRepository;
    }

    public Application createApplication(Application application) {

        if (!studentRepository.existsById(application.getStudentId())) {
            throw new RuntimeException(
                    "Student not found with id: " + application.getStudentId());
        }

        if (!jobRepository.existsById(application.getJobId())) {
            throw new RuntimeException(
                    "Job not found with id: " + application.getJobId());
        }
        if (applicationRepository.existsByStudentIdAndJobId(
                application.getStudentId(),
                application.getJobId())) {

            throw new RuntimeException(
                    "Student has already applied for this job");
        }
        application.setStatus("Applied");

        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
    public List<Application> getApplicationsByStudentId(Long studentId) {
        return applicationRepository.findByStudentId(studentId);
    }
    
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Application not found with id: " + id));
    }

    public Application updateApplication(Long id, Application updatedApplication) {

        Application existingApplication = getApplicationById(id);

        if (!studentRepository.existsById(updatedApplication.getStudentId())) {
            throw new RuntimeException(
                    "Student not found with id: " + updatedApplication.getStudentId());
        }

        if (!jobRepository.existsById(updatedApplication.getJobId())) {
            throw new RuntimeException(
                    "Job not found with id: " + updatedApplication.getJobId());
        }
        

        existingApplication.setStudentId(updatedApplication.getStudentId());
        existingApplication.setJobId(updatedApplication.getJobId());
        existingApplication.setStatus(updatedApplication.getStatus());

        return applicationRepository.save(existingApplication);
    }

    public void deleteApplication(Long id) {
        Application existingApplication = getApplicationById(id);
        applicationRepository.delete(existingApplication);
    }
}