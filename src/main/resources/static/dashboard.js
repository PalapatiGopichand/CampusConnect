document.addEventListener("DOMContentLoaded", loadStudentDashboard);

function loadStudentDashboard() {

    // Check whether a student is logged in
    const storedStudent = localStorage.getItem("student");

    if (!storedStudent) {

        alert("Please login to access the dashboard.");

        window.location.href = "login.html";

        return;
    }

    const student = JSON.parse(storedStudent);

    // Student name
    document.getElementById("studentName").textContent =
        student.fullName;

    // Department under the name
    document.getElementById("studentDepartment").textContent =
        student.department;

    // Student status
    document.getElementById("studentStatus").textContent =
        student.status;

    // Email
    document.getElementById("studentEmail").textContent =
        student.email;

    // Phone
    document.getElementById("studentPhone").textContent =
        student.phone;

    // Department
    document.getElementById("studentDepartment2").textContent =
        student.department;

    // Graduation year
    document.getElementById("studentGraduationYear").textContent =
        student.graduationYear;

    // Load dashboard statistics
    loadJobCount();
    loadApplicationCount();
}


/* Load available job count */

async function loadJobCount() {

    try {

        const response = await fetch("/jobs");

        if (!response.ok) {
            throw new Error("Unable to load jobs");
        }

        const jobs = await response.json();

        document.getElementById("availableJobs").textContent =
            jobs.length;

    } catch (error) {

        console.error("Job loading error:", error);

        document.getElementById("availableJobs").textContent = "0";
    }
}


/* Load application count */

async function loadApplicationCount() {

    try {

        const storedStudent = localStorage.getItem("student");

        if (!storedStudent) {
            throw new Error("Student not logged in");
        }

        const student = JSON.parse(storedStudent);

        const response = await fetch(
            `/applications/student/${student.id}`
        );

        if (!response.ok) {
            throw new Error("Unable to load applications");
        }

        const applications = await response.json();

        // Total applications
        document.getElementById("appliedJobs").textContent =
            applications.length;

        // Applications with Shortlisted status
        const shortlistedCount = applications.filter(
            application =>
                application.status &&
                application.status.toLowerCase() === "shortlisted"
        ).length;

        document.getElementById("shortlistedJobs").textContent =
            shortlistedCount;

    } catch (error) {

        console.error("Application loading error:", error);

        document.getElementById("appliedJobs").textContent = "0";
        document.getElementById("shortlistedJobs").textContent = "0";
    }
}


/* Logout */

const logoutLink = document.getElementById("logoutLink");

if (logoutLink) {

    logoutLink.addEventListener("click", function(event) {

        event.preventDefault();

        localStorage.removeItem("student");

        window.location.href = "login.html";

    });
}