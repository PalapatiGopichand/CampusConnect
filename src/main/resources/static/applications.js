document.addEventListener("DOMContentLoaded", loadApplications);


async function loadApplications() {

    const container =
        document.getElementById("applicationsContainer");

    try {

        // Get students
        const studentResponse =
            await fetch("/api/students");

        if (!studentResponse.ok) {
            throw new Error("Unable to load students");
        }

        const students =
            await studentResponse.json();


        if (!students || students.length === 0) {

            container.innerHTML = `
                <div class="no-applications">

                    <h2>No Student Found</h2>

                    <p>
                        Please register as a student first.
                    </p>

                </div>
            `;

            return;
        }


        // Use the latest registered student
        const student =
            students[students.length - 1];


        // Get applications
        const applicationResponse =
            await fetch("/applications");

        if (!applicationResponse.ok) {
            throw new Error("Unable to load applications");
        }

        const applications =
            await applicationResponse.json();


        // Get jobs
        const jobsResponse =
            await fetch("/jobs");

        if (!jobsResponse.ok) {
            throw new Error("Unable to load jobs");
        }

        const jobs =
            await jobsResponse.json();


        // Show only this student's applications
        const studentApplications =
            applications.filter(
                application =>
                    application.studentId === student.id
            );


        container.innerHTML = "";


        // No applications for this student
        if (studentApplications.length === 0) {

            container.innerHTML = `
                <div class="no-applications">

                    <h2>No Applications Yet</h2>

                    <p>
                        You have not applied for any jobs yet.
                    </p>

                    <a href="jobs.html"
                       class="btn btn-primary">

                        Explore Jobs →

                    </a>

                </div>
            `;

            return;
        }


        // Display student's applications
        studentApplications.forEach(application => {

            const job =
                jobs.find(
                    job => job.id === application.jobId
                );


            const applicationCard =
                document.createElement("div");

            applicationCard.className =
                "application-card";


            applicationCard.innerHTML = `

                <div class="application-icon">
                    💼
                </div>

                <div class="application-info">

                    <h2>
                        ${
                            job
                                ? job.jobTitle
                                : "Job Information Unavailable"
                        }
                    </h2>

                    <p class="application-company">

                        ${
                            job
                                ? job.companyName
                                : "Unknown Company"
                        }

                    </p>

                    <p>
                        📍
                        ${
                            job
                                ? job.location
                                : "Not available"
                        }
                    </p>

                </div>

                <div class="application-status">

				<span class="status-badge application-status-badge status-${application.status.toLowerCase()}">
				    ${application.status}
				</span>
                    

                    <small>
                        Application ID:
                        ${application.id}
                    </small>

                </div>

            `;


            container.appendChild(applicationCard);

        });


    } catch (error) {

        console.error(
            "Application loading error:",
            error
        );


        container.innerHTML = `

            <div class="no-applications">

                <h2>
                    Unable to Load Applications
                </h2>

                <p>
                    Please make sure CampusConnect
                    is running.
                </p>

            </div>

        `;
    }
}