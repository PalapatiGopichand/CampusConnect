document.addEventListener("DOMContentLoaded", loadJobs);


async function loadJobs() {

    const jobsContainer = document.getElementById("jobsContainer");

    try {

        const response = await fetch("/jobs");

        if (!response.ok) {
            throw new Error("Unable to load jobs");
        }

        const jobs = await response.json();

        jobsContainer.innerHTML = "";

        if (!jobs || jobs.length === 0) {

            jobsContainer.innerHTML = `
                <div class="no-jobs">
                    <h2>No jobs available</h2>
                    <p>Please check back later for new opportunities.</p>
                </div>
            `;

            return;
        }


        jobs.forEach(job => {

            const jobCard = document.createElement("div");

            jobCard.className = "job-card";


            jobCard.innerHTML = `

                <div class="job-card-icon">
                    💼
                </div>

                <div class="job-card-content">

                    <h2>${job.jobTitle}</h2>

                    <p class="job-company">
                        ${job.companyName}
                    </p>

                    <p>
                        📍 ${job.location}
                    </p>

                    <p>
                        💰 ₹${job.packageAmount} LPA
                    </p>

                    <p class="job-description">
                        ${job.description}
                    </p>

                </div>

                <button class="btn btn-primary"
                        onclick="applyForJob(${job.id})">

                    Apply Now →

                </button>

            `;

            jobsContainer.appendChild(jobCard);

        });


    } catch (error) {

        console.error("Job loading error:", error);

        jobsContainer.innerHTML = `
            <div class="no-jobs">
                <h2>Unable to load jobs</h2>
                <p>
                    Please make sure CampusConnect is running.
                </p>
            </div>
        `;
    }
}


/* Apply for a job */

async function applyForJob(jobId) {

    try {

        // Get the currently logged-in student
        const storedStudent = localStorage.getItem("student");

        if (!storedStudent) {

            alert("Please login before applying for a job.");

            window.location.href = "login.html";

            return;
        }

        const student = JSON.parse(storedStudent);

        // Create application for the logged-in student
        const application = {

            studentId: student.id,
            jobId: jobId,
            status: "Applied"

        };

        // Submit application
        const response = await fetch("/applications", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(application)

        });

        const data = await response.json();

        if (response.ok) {

            alert(
                "Application submitted successfully! 🎉"
            );

        } else {

            alert(
                data.message ||
                "Unable to submit application."
            );

        }

    } catch (error) {

        console.error("Application error:", error);

        alert(
            "Unable to submit application. " +
            "Please make sure CampusConnect is running."
        );

    }

}
