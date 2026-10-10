package com.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusconnect.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}