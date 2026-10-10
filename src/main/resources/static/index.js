javascript
document.addEventListener("DOMContentLoaded", function () {

    const navLinks = document.getElementById("navLinks");

    // Stop if this page does not have the navigation element
    if (!navLinks) {
        return;
    }

    const storedStudent = localStorage.getItem("student");

    // Find the Register Now button in the Hero section
    const heroRegisterButton =
        document.querySelector(".hero-buttons .btn-secondary");

    if (storedStudent) {

        // Hide Register Now when logged in
        if (heroRegisterButton) {
            heroRegisterButton.style.display = "none";
        }

        // Update navbar for logged-in students
        navLinks.innerHTML = `
            <li><a href="index.html">Home</a></li>
            <li><a href="jobs.html">Jobs</a></li>
            <li><a href="dashboard.html">Dashboard</a></li>
            <li><a href="applications.html">Applications</a></li>
            <li><a href="#" id="logoutLink">Logout</a></li>
        `;

        document.getElementById("logoutLink")
            .addEventListener("click", function (event) {

                event.preventDefault();

                localStorage.removeItem("student");

                window.location.href = "login.html";
            });

    } else {

        // Show Register Now when logged out
        if (heroRegisterButton) {
            heroRegisterButton.style.display = "";
        }

    }

});
