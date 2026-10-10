package com.campusconnect.dto;

public class LoginResponse {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String department;
    private Integer graduationYear;
    private String status;

    public LoginResponse(Long id, String fullName, String email,
                         String phone, String department,
                         Integer graduationYear, String status) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.graduationYear = graduationYear;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public String getStatus() {
        return status;
    }
}