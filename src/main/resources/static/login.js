document.getElementById("loginForm").addEventListener("submit", async function(event) {

    event.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {

        const response = await fetch("/api/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        });

        if (response.ok) {

            const student = await response.json();

            // Store logged-in student information
            localStorage.setItem("student", JSON.stringify(student));

            // Go to dashboard
            window.location.href = "dashboard.html";

        } else {

            alert("Invalid email or password.");

        }

    } catch (error) {

        console.error("Login error:", error);

        alert("Unable to connect to CampusConnect. Please try again.");

    }

});