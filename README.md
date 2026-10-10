
					
# CampusConnect

CampusConnect is a Student Placement Management Portal developed using Java and Spring Boot.

## Features

- Student Management
- Job Management
- Student Job Applications
- Student Search
- Input Validation
- Duplicate Application Prevention
- Exception Handling
- REST APIs

## Technologies Used

- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- MySQL
- Maven
- Postman
- Eclipse

## Project Modules

### Student Management
Manage student details such as:
- Name
- Email
- Phone
- Department
- Graduation Year
- Placement Status

### Job Management
Manage:
- Company Name
- Job Title
- Job Description
- Location
- Package

### Application Management
Students can apply for available jobs.

The system checks:
- Whether the student exists
- Whether the job exists
- Whether the student has already applied

## API Endpoints

### Students

POST `/api/students`

GET `/api/students`

GET `/api/students/{id}`

PUT `/api/students/{id}`

DELETE `/api/students/{id}`

### Jobs

POST `/jobs`

GET `/jobs`

GET `/jobs/{id}`

PUT `/jobs/{id}`

DELETE `/jobs/{id}`

### Applications

POST `/applications`

GET `/applications`

GET `/applications/{id}`

PUT `/applications/{id}`

DELETE `/applications/{id}`

### Health Check

GET `/api/health`

## How to Run

1. Install Java 21.
2. Install MySQL.
3. Create the CampusConnect database.
4. Configure the database details in `application.properties`.
5. Run `CampusConnectApplication.java`.
6. Test the APIs using Postman.

## Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database

## Future Improvements

- User Authentication
- Admin Dashboard
- Resume Upload
- Company Management
- Application Status Tracking
- React Frontend

## Author

P.Gopichand

B.Tech Computer Science Engineering