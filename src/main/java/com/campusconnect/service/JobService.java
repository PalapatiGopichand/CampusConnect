package com.campusconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campusconnect.entity.Job;
import com.campusconnect.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    public Job updateJob(Long id, Job updatedJob) {

        Job existingJob = getJobById(id);

        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setJobTitle(updatedJob.getJobTitle());
        existingJob.setDescription(updatedJob.getDescription());
        existingJob.setLocation(updatedJob.getLocation());
        existingJob.setPackageAmount(updatedJob.getPackageAmount());

        return jobRepository.save(existingJob);
    }

    public void deleteJob(Long id) {
        Job existingJob = getJobById(id);
        jobRepository.delete(existingJob);
    }
}