# 🎓 CampusConnect — Student Placement Portal

A full-stack student placement portal developed using **Java, Spring Boot, Spring Data JPA, Hibernate, MySQL, HTML, CSS, and JavaScript**.

CampusConnect helps students register, log in, explore job opportunities, apply for jobs, and view their applications through a simple web interface.

This project was developed as a hands-on learning project to understand how frontend technologies, backend REST APIs, databases, and GitHub work together in a real-world application.

---

## 📌 Table of Contents

1. Project Overview
2. Project Objectives
3. Features
4. Technologies Used
5. Application Architecture
6. Complete Application Workflow
7. Project Folder Structure
8. Backend Explained
9. Frontend Explained
10. Database Explained
11. Application Configuration
12. REST API Concepts
13. How to Run the Project
14. How to Test the Application
15. Common Errors and Solutions
16. Important Java and Spring Boot Concepts
17. Current Limitations
18. Future Improvements
19. Learning Outcomes
20. Author

---

## 1. Project Overview

CampusConnect is a web-based student placement portal that connects students with job opportunities.

The application contains a frontend, a backend, and a database.

- **Frontend:** Displays web pages and collects information from students.
- **Backend:** Processes requests, validates data, applies business rules, and communicates with the database.
- **Database:** Stores student details, job information, and job applications.

For example, when a student applies for a job, the frontend sends a request to the backend. The backend checks whether the student and job exist, prevents duplicate applications, and saves the application in MySQL.

This demonstrates how a complete web application works from the user's browser to the database.

## 2. Project Objectives

The main objectives of CampusConnect are:

- Build a complete web application using Java and Spring Boot.
- Understand REST API development.
- Perform database operations using Spring Data JPA and Hibernate.
- Implement student registration and login.
- Create and manage student, job, and application records.
- Connect HTML, CSS, and JavaScript pages to backend APIs.
- Validate incoming data and handle errors.
- Practice software development, testing, and Git version control.

## 3. Features

### Student Management
- Register a new student.
- Store student information in MySQL.
- Retrieve student records.
- Update student information.
- Delete student records.
- Validate required fields and student details.

### Student Login
- Log in using the credentials supported by the application.
- Display a student dashboard after login.
- Use browser local storage to maintain the frontend login state.
- Log out and clear the stored student information.

**Note:** The current frontend login-state mechanism is a learning implementation. Browser local storage is not secure authentication and should not be treated as an authorization mechanism for a production application.

### Job Management
- Retrieve available jobs from the backend.
- Display job opportunities on the Jobs page.
- Show job details to students.
- Allow students to start the application process.

### Job Applications
- Submit a job application for a student.
- Check whether the student exists.
- Check whether the selected job exists.
- Prevent duplicate applications according to the implemented business logic.
- Retrieve application records.

### User Interface
- Home page with project introduction.
- Student registration page.
- Login page.
- Student dashboard.
- Jobs page.
- Applications page.
- Shared styling using CSS.
- Navigation between pages.

---

## 4. Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Main programming language |
| Spring Boot 3.5.6 | Backend application framework |
| Spring Web | Handles HTTP requests and REST APIs |
| Spring Data JPA | Simplifies database access |
| Hibernate | Maps Java objects to database tables |
| MySQL | Stores application data |
| Maven | Manages dependencies and builds the project |
| HTML5 | Defines the structure of web pages |
| CSS3 | Styles the user interface |
| JavaScript | Handles frontend interactions and API requests |
| Eclipse IDE | Development environment |
| Postman | Tests backend APIs |
| Git | Tracks source-code changes |
| GitHub | Hosts the source code online |

---

## 5. Application Architecture

CampusConnect follows a layered architecture.

```text
                 STUDENT
                    |
                    v
          HTML + CSS + JavaScript
                    |
                    v
             HTTP / REST API
                    |
                    v
               CONTROLLER
                    |
                    v
                 SERVICE
                    |
                    v
               REPOSITORY
                    |
                    v
              Spring Data JPA
                    |
                    v
                 HIBERNATE
                    |
                    v
                MySQL DB
```

### How the layers work

**1. Frontend**

The frontend displays the pages and collects user input.

For example, the registration form collects the student's name, email, phone number, department, graduation year, and password.

**2. Controller**

The controller receives an HTTP request and determines which backend operation should handle it.

For example, a student registration request is handled by `StudentController`.

**3. Service**

The service contains the application's business logic.

For example, `StudentService` checks whether an email address is already registered before creating a student.

**4. Repository**

The repository communicates with the database through Spring Data JPA.

It provides methods for saving, finding, updating, and deleting records.

**5. Hibernate and JPA**

JPA defines the standard for mapping Java objects to database records. Hibernate implements that standard and generates SQL statements when needed.

**6. MySQL**

MySQL permanently stores the application data in database tables.

---

## 6. Complete Application Workflow

### Workflow 1: Student Registration

1. The student opens `register.html`.
2. The student enters the required information.
3. JavaScript reads the form values.
4. JavaScript sends an HTTP POST request to the registration API.
5. `StudentController` receives the request.
6. Spring validates the submitted data according to the controller and validation rules.
7. `StudentService` checks whether the email already exists.
8. `StudentRepository` saves the student if registration is valid.
9. Hibernate generates the required database operation.
10. MySQL stores the student record.
11. The backend sends a response to the frontend.
12. The frontend displays the result to the student.

If validation fails or the email is already registered, the request should return an appropriate error response according to the application's exception-handling logic.

### Workflow 2: Student Login

1. The student opens `login.html`.
2. The student enters their email and password.
3. `login.js` collects the login information.
4. The frontend sends the credentials to the login endpoint.
5. `LoginController` processes the login request.
6. The backend checks the credentials using the implemented login logic.
7. If the credentials are accepted, the frontend stores student information in browser local storage.
8. The student is redirected to the dashboard.
9. The dashboard JavaScript checks the stored login state.

The current implementation uses a simple login-state mechanism. It does not provide the security guarantees of a production authentication system using Spring Security and secure sessions or tokens.

### Workflow 3: Viewing Jobs

1. The student opens `jobs.html`.
2. `jobs.js` requests job information from the backend.
3. `JobController` handles the request.
4. `JobService` processes the operation.
5. `JobRepository` retrieves job records.
6. The backend returns the available jobs.
7. JavaScript reads the response.
8. The jobs are displayed on the page.

The exact fields shown depend on the job entity and the frontend rendering code.

### Workflow 4: Applying for a Job

1. The student opens the Jobs page.
2. The student selects a job and clicks the Apply button.
3. JavaScript identifies the logged-in student and selected job.
4. The frontend sends an application request to the backend.
5. `ApplicationController` receives the request.
6. `ApplicationService` checks whether the student exists.
7. It checks whether the selected job exists.
8. It checks whether the student has already applied, according to the implemented duplicate-application logic.
9. If the checks succeed, `ApplicationRepository` saves the application.
10. The backend returns the result.
11. The frontend displays a success or error message.

### Workflow 5: Viewing Applications

1. The student opens `applications.html`.
2. `applications.js` requests application records.
3. `ApplicationController` handles the request.
4. The backend retrieves the relevant records through the service and repository layers.
5. The response is returned to the browser.
6. JavaScript displays the application information.

The current project should be reviewed to ensure that each student can access only their own applications. Frontend filtering alone is not sufficient for secure access control.

### Workflow 6: Logout

1. The student clicks Logout.
2. The JavaScript logout handler runs.
3. The application removes the stored student information from local storage.
4. The browser redirects to the login page.
5. The frontend displays the logged-out navigation.

Because local storage is controlled by the browser, this workflow is suitable for learning but is not a replacement for server-side session invalidation or secure token handling.

---

## 7. Project Folder Structure

The main source-code structure is:

```text
campusconnect/
│
├── .gitignore
├── README.md
├── pom.xml
│
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── campusconnect/
        │           ├── CampusConnectApplication.java
        │           │
        │           ├── controller/
        │           │   ├── ApplicationController.java
        │           │   ├── HomeController.java
        │           │   ├── JobController.java
        │           │   ├── LoginController.java
        │           │   └── StudentController.java
        │           │
        │           ├── dto/
        │           │   ├── LoginRequest.java
        │           │   └── LoginResponse.java
        │           │
        │           ├── entity/
        │           │   ├── Application.java
        │           │   ├── Job.java
        │           │   └── Student.java
        │           │
        │           ├── exception/
        │           │   └── GlobalExceptionHandler.java
        │           │
        │           ├── repository/
        │           │   ├── ApplicationRepository.java
        │           │   ├── JobRepository.java
        │           │   └── StudentRepository.java
        │           │
        │           └── service/
        │               ├── ApplicationService.java
        │               ├── JobService.java
        │               └── StudentService.java
        │
        └── resources/
            ├── application.properties
            │
            └── static/
                ├── applications.html
                ├── applications.js
                ├── dashboard.html
                ├── dashboard.js
                ├── index.html
                ├── index.js
                ├── jobs.html
                ├── jobs.js
                ├── login.html
                ├── login.js
                ├── register.html
                ├── script.js
                └── style.css
```

### What each folder means

- `controller/`: Receives requests from the frontend.
- `dto/`: Defines objects used to transfer login request and response data.
- `entity/`: Defines Java objects mapped to database tables.
- `exception/`: Handles selected errors centrally.
- `repository/`: Provides database access methods.
- `service/`: Contains business logic.
- `resources/static/`: Contains the frontend pages, scripts, and styles.
- `application.properties`: Contains Spring Boot configuration.
- `pom.xml`: Defines Maven dependencies and build configuration.
- `.gitignore`: Excludes generated and local files from Git tracking.
- `README.md`: Documents the project.

---

## 8. Backend Explained

### 8.1 CampusConnectApplication.java

This is the entry point of the Spring Boot application.

The class contains the `main()` method, which starts the application using `SpringApplication.run(...)`.

When the application starts, Spring Boot configures the application context, discovers components, configures the web server, and initializes the configured database integration.

### 8.2 StudentController.java

This controller handles HTTP requests related to student management.

Its responsibilities include:

- Accepting student registration requests.
- Retrieving student records.
- Retrieving an individual student by ID.
- Updating student information.
- Deleting student records.
- Applying request validation where configured.
- Returning appropriate HTTP responses.

The controller should delegate business operations to `StudentService` rather than implementing all business rules itself.

### 8.3 StudentService.java

This service contains student-related business rules.

Important concepts include:

- Checking whether an email already exists.
- Registering students.
- Retrieving student records.
- Updating student information.
- Deleting student records.
- Throwing an exception when an operation cannot be completed.

For example, a repository method such as `existsByEmail(email)` checks whether the email already belongs to a student. If it does, the service can reject registration rather than creating a duplicate record.

### 8.4 StudentRepository.java

This interface provides database operations for the Student entity.

Spring Data JPA can generate implementations for supported repository methods automatically.

Examples of common repository operations include:

- `save(...)` — saves a record.
- `findById(...)` — searches by ID.
- `findAll()` — retrieves all records.
- `deleteById(...)` — deletes by ID.
- `existsByEmail(...)` — checks whether an email exists, if declared.
- `findByEmail(...)` — searches by email, if declared.

The precise methods available are those defined in the project's repository interface.

### 8.5 Student.java

This is the Student entity.

An entity is a Java class whose objects are mapped to database records.

The class contains the student fields and their associated getters, setters, constructors, and JPA annotations as implemented in the source code.

A typical entity uses `@Entity` to identify it as a persistent entity and `@Id` to identify its primary key.

### 8.6 JobController.java, JobService.java, and JobRepository.java

These classes implement the job-management layer.

- `JobController` receives job-related HTTP requests.
- `JobService` contains job-related operations.
- `JobRepository` provides database access for job records.
- `Job.java` represents a job entity.

This separation makes the code easier to understand, maintain, and test.

### 8.7 ApplicationController.java, ApplicationService.java, and ApplicationRepository.java

These classes implement the job-application workflow.

- `ApplicationController` receives application requests.
- `ApplicationService` applies the business rules.
- `ApplicationRepository` stores and retrieves application records.
- `Application.java` represents a student application.

The service checks the required student and job records before saving an application and includes logic to prevent duplicate applications.

### 8.8 LoginController.java

This controller handles login-related requests.

It uses the login request and response objects to transfer information between the frontend and backend.

A login request carries the information submitted by the student. The response communicates the result of the login operation according to the implemented logic.

The current login mechanism should not be considered production-grade authentication without server-side authorization and secure password handling.

### 8.9 LoginRequest.java and LoginResponse.java

These are Data Transfer Objects, commonly called DTOs.

A DTO defines the data exchanged between application components.

- `LoginRequest.java` represents incoming login information.
- `LoginResponse.java` represents the login result returned by the backend.

DTOs help keep request and response structures separate from database entity classes.

### 8.10 GlobalExceptionHandler.java

This class provides centralized handling for selected application errors.

Instead of repeating error-handling logic in every controller, a global exception handler can return consistent error responses.

Depending on the configured exception-handler methods, it can handle validation failures and application exceptions.

### 8.11 HomeController.java

This controller handles the home route or other home-page requests defined in its mappings.

The HTML pages are stored under `resources/static/`, so Spring Boot can serve them as static resources.

The exact responsibility of this controller depends on its request-mapping annotations and method implementations.

---

## 9. Frontend Explained

The frontend is built with HTML, CSS, and JavaScript.

### HTML files

**index.html**

Displays the home page, project introduction, navigation, and links to other pages.

**register.html**

Contains the student registration form.

**login.html**

Contains the student login form.

**dashboard.html**

Displays the student dashboard.

**jobs.html**

Displays job opportunities retrieved or rendered by the frontend code.

**applications.html**

Displays student application information.

### JavaScript files

**index.js and script.js**

Contain home-page or shared navigation behavior as implemented in the respective files.

**login.js**

Handles login form interactions, submits login information, processes the response, and performs the implemented login navigation.

**dashboard.js**

Handles dashboard-specific behavior, including reading stored student information and displaying dashboard data.

**jobs.js**

Handles job-page interactions and requests job information from the backend.

**applications.js**

Handles application-page interactions and retrieves or renders application information.

### style.css

Defines the visual appearance of the pages.

CSS controls properties such as colors, spacing, typography, layout, borders, buttons, and responsive behavior.

### How JavaScript communicates with Spring Boot

JavaScript can use the Fetch API to send HTTP requests.

A simplified example is:

```javascript
fetch("/api/students")
    .then(response => response.json())
    .then(data => {
        console.log(data);
    });
```

Explanation:

1. `fetch("/api/students")` sends an HTTP request to the specified endpoint.
2. `.then(response => response.json())` converts a JSON response into a JavaScript value.
3. `.then(data => ...)` receives the converted data.
4. `console.log(data)` prints the result in the browser console.

This is an illustrative example of the Fetch API, not a replacement for the exact code in the project's JavaScript files.

---

## 10. Database Explained

CampusConnect uses MySQL to store its data.

### Database name

`campusconnect_db`

The project has three main entities:

### Student

Represents a registered student.

The actual fields are defined in `Student.java`.

### Job

Represents a job opportunity.

The actual fields are defined in `Job.java`.

### Application

Represents a student's application for a job.

The actual fields and relationships are defined in `Application.java`.

### Entity relationships

Conceptually:

```text
Student 1 -------- many Applications

Job     1 -------- many Applications
```

One student can apply for multiple jobs, and one job can receive applications from multiple students.

Each application connects a student to a job. The exact database relationships are determined by the JPA annotations in the entity classes.

### How data reaches MySQL

1. The controller receives the request.
2. The service applies the business rules.
3. The repository performs the requested data operation.
4. Hibernate translates entity operations into SQL.
5. MySQL executes the SQL.
6. The backend returns a response.

---

## 11. Application Configuration

The configuration file is:

`src/main/resources/application.properties`

The current local development configuration is:

```properties
spring.application.name=CampusConnect

spring.datasource.url=jdbc:mysql://localhost:3306/campusconnect_db
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8081
```

### Explanation of each property

**`spring.application.name=CampusConnect`**

Sets the application name.

**`spring.datasource.url=jdbc:mysql://localhost:3306/campusconnect_db`**

Specifies the MySQL server, port, and database name.

- `localhost` means the database is running on the same computer.
- `3306` is the default MySQL port.
- `campusconnect_db` is the database name.

**`spring.datasource.username=root`**

Sets the MySQL username for this local configuration.

**`spring.datasource.password=`**

Specifies an empty database password. This matches the current local setup, but it should not be assumed safe or appropriate for every environment.

**`spring.jpa.hibernate.ddl-auto=update`**

Allows Hibernate to update the database schema based on entity changes.

This setting is useful during development. Production systems generally require a controlled database migration strategy.

**`spring.jpa.show-sql=true`**

Displays generated SQL statements in the application logs. This can help beginners understand how entity operations interact with the database.

**`server.port=8081`**

Runs the embedded web server on port 8081.

### Security note

The current configuration is for local development only. Use environment variables or a secure configuration mechanism for deployment, and never commit real database passwords, API keys, or other secrets to GitHub.

---

## 12. REST API Concepts

REST APIs allow the frontend and backend to communicate using HTTP.

Common HTTP methods include:

| Method | Meaning | Typical use |
|---|---|---|
| GET | Read data | Retrieve students or jobs |
| POST | Create data | Register a student or submit an application |
| PUT | Update data | Update a student record |
| DELETE | Delete data | Remove a student record |

For example, a controller may use annotations such as `@GetMapping`, `@PostMapping`, `@PutMapping`, and `@DeleteMapping` to map requests to Java methods.

The exact URL of an endpoint depends on the controller's class-level and method-level mappings.

To see the exact endpoints implemented in CampusConnect, inspect the `@RequestMapping` and HTTP mapping annotations in each controller.

### HTTP status codes

- `200 OK` — a request succeeded.
- `201 Created` — a resource was created, when returned by the implementation.
- `400 Bad Request` — the request contains invalid data.
- `404 Not Found` — a requested resource was not found.
- `409 Conflict` — the request conflicts with existing data, such as a duplicate email, when handled that way.
- `500 Internal Server Error` — an unexpected server error occurred.

The actual status code depends on the endpoint implementation and exception handling.

---

## 13. How to Run the Project

### Prerequisites

Install or configure:

- Java JDK 21.
- Eclipse IDE or another Java IDE.
- MySQL Server or a compatible local MySQL setup.
- Maven, or use the Maven tooling included in Eclipse.
- Postman for API testing, if desired.
- A web browser.

### Step 1: Clone the repository

Open PowerShell and run:

```bash
git clone https://github.com/PalapatiGopichand/CampusConnect.git
```

Enter the project folder:

```bash
cd CampusConnect
```

### Step 2: Create the database

Start MySQL and create the database:

```sql
CREATE DATABASE campusconnect_db;
```

Make sure the database username and password in `application.properties` match your local MySQL configuration.

### Step 3: Open the project in Eclipse

1. Open Eclipse.
2. Choose the option to import an existing Maven project.
3. Select the cloned `CampusConnect` folder.
4. Finish the import.
5. Allow Maven to download the required dependencies.

### Step 4: Run the Spring Boot application

Locate `CampusConnectApplication.java`.

Right-click the file and select:

**Run As → Java Application**

If the project is configured correctly, Spring Boot should start its embedded server on port 8081.

### Step 5: Open the application

Open this URL in your browser:

`http://localhost:8081/`

Spring Boot serves the frontend files from `src/main/resources/static/`.

### Step 6: Test the workflow

1. Register a student.
2. Log in with the supported credentials.
3. Open the dashboard.
4. View available jobs.
5. Apply for a job.
6. View the application information.
7. Log out.

If an endpoint fails, inspect the browser console, the Network tab in Developer Tools, and the Spring Boot console.

---

## 14. How to Test the Application

### Frontend testing

Check that:

- Each HTML page opens.
- Navigation links lead to the correct pages.
- Forms collect the expected information.
- Invalid input produces understandable feedback.
- Job records appear correctly.
- Application information is rendered correctly.
- Login and logout behave as implemented.

### Backend testing

Use Postman to test the controller endpoints.

For each endpoint, verify:

- The request method is correct.
- The URL matches the controller mappings.
- The request body contains valid JSON where required.
- The response status is appropriate.
- The response body contains the expected data.
- Invalid input is handled appropriately.

### Database testing

Use a database client or phpMyAdmin to confirm that:

- Registered students are stored.
- Jobs are available to retrieve.
- Applications are saved.
- Duplicate applications are handled according to the business rules.

### Integration testing

Integration testing checks whether the frontend, backend, and database work together as one application.

For example, a successful job application should be visible in the database and should appear in the application page according to the implemented retrieval logic.

---

## 15. Common Errors and Solutions

### Error: Whitelabel Error Page or 404

**Possible causes:**

- The URL does not match a controller mapping.
- The requested static file does not exist.
- The application is running with a different route configuration.

**What to check:**

- Confirm the application is running.
- Verify the URL.
- Check the controller mappings.
- Confirm the HTML file is under `src/main/resources/static/`.

### Error: Connection refused

**Possible causes:**

- Spring Boot is not running.
- The application uses a different port.
- Another application is occupying the configured port.

**What to check:**

- Inspect the Eclipse console.
- Confirm that port 8081 is available.
- Restart the application if needed.

### Error: Database connection failed

**Possible causes:**

- MySQL is stopped.
- The database does not exist.
- The username or password is incorrect.
- The JDBC URL is incorrect.

**What to check:**

- Start MySQL.
- Create `campusconnect_db`.
- Verify `application.properties`.
- Confirm the MySQL port and credentials.

### Error: 400 Bad Request

**Possible causes:**

- Required fields are missing.
- Input validation failed.
- JSON properties have incorrect names or data types.

**What to check:**

- Inspect the response body.
- Compare the request with the entity, DTO, and validation rules.
- Check whether all required fields have been supplied.

### Error: Duplicate email

The application may reject registration when the email address already exists.

Use a different email address for a new registration or follow the application's account-recovery or update logic where available.

### Error: Duplicate application

The application service includes logic to prevent repeated applications for the same student and job. Check whether the application already exists before retrying.

---

## 16. Important Java and Spring Boot Concepts

### Class

A class defines the structure and behavior of objects.

For example, `Student` defines the data and operations associated with a student.

### Object

An object is an instance of a class.

A student retrieved from the database can be represented as a Java object.

### Method

A method is a named block of code that performs an operation.

For example, a service method may register a student or retrieve a job.

### Annotation

An annotation provides metadata that frameworks can use.

Examples include:

- `@SpringBootApplication` — identifies the Spring Boot application entry point.
- `@RestController` — identifies a REST controller.
- `@Service` — identifies a service component.
- `@Repository` — identifies a repository component.
- `@Entity` — identifies a persistent entity.
- `@Id` — identifies a primary key.
- `@GetMapping` — maps HTTP GET requests.
- `@PostMapping` — maps HTTP POST requests.
- `@Valid` — triggers applicable validation for an object.

The exact behavior depends on where and how an annotation is used.

### Dependency Injection

Dependency injection allows Spring to provide the objects that a class needs.

For example, a service can receive a repository through its constructor instead of creating the repository implementation manually.

### JPA Entity

An entity is a Java class mapped to a database table or other persistent structure.

### Repository

A repository provides methods for reading and writing persistent data.

### Exception Handling

An exception represents an error or unexpected condition. Exception handlers can convert selected exceptions into useful HTTP responses.

### JSON

JSON is a text format commonly used to exchange structured data between JavaScript and Java applications.

### Local Storage

Browser local storage stores key-value pairs in the browser. It can retain data between page loads, but users can modify it, so it must not be trusted for server-side authorization.

### Git and GitHub

Git tracks changes to files and creates commits. GitHub hosts Git repositories online so developers can share and collaborate on code.

---

## 17. Current Limitations

CampusConnect is a learning and portfolio project. The following areas require additional work before it should be used as a production placement platform:

- Implement secure authentication and server-side authorization.
- Store passwords using a suitable password-hashing mechanism such as BCrypt.
- Ensure students can access only their own application records.
- Protect sensitive endpoints against unauthorized access.
- Replace local database configuration with environment-specific configuration.
- Improve automated unit and integration test coverage.
- Review validation and error handling across every endpoint.
- Introduce a controlled database migration strategy for production.
- Add deployment configuration and monitoring.
- Review the consistency of frontend navigation and login state.

These improvements would make the application more suitable for real-world use.

---

## 18. Future Improvements

Potential future enhancements include:

- Spring Security authentication.
- Password hashing and secure session management.
- Separate student and administrator roles.
- An administrator dashboard for managing jobs.
- Search and filtering for job opportunities.
- Application status tracking.
- Email notifications.
- Pagination and sorting.
- Automated testing using JUnit and Spring Boot Test.
- Deployment to a cloud platform.
- Continuous integration and delivery.
- Improved accessibility and responsive design.

---

## 19. Learning Outcomes

By building CampusConnect, the following concepts can be practised:

- Java application development.
- Object-oriented programming.
- Spring Boot application structure.
- REST API design.
- Request mapping and validation.
- Service and repository layers.
- JPA entity mapping.
- MySQL integration.
- CRUD operations.
- Frontend and backend integration.
- Browser JavaScript and local storage.
- Error handling.
- API testing with Postman.
- Maven dependency management.
- Git commits and GitHub repository management.

---

## 20. Author

**Project:** CampusConnect — Student Placement Portal

**Developer:** Palapati Gopichand

**GitHub Repository:**  
https://github.com/PalapatiGopichand/CampusConnect

---

## License

No license has been specified for this project. Unless a license is added, the repository should not be assumed to grant others permission to reuse or redistribute the code.

---

**CampusConnect demonstrates the integration of a Java backend, relational database, and web frontend in a student placement portal.**
