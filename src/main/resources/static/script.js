const registrationForm = document.getElementById("registrationForm");

if (registrationForm) {

    registrationForm.addEventListener("submit", async function (event) {

        event.preventDefault();

        const student = {

            fullName:
                document.getElementById("fullName").value.trim(),

            email:
                document.getElementById("email").value.trim(),

            password:
                document.getElementById("password").value,

            phone:
                document.getElementById("phone").value.trim(),

            department:
                document.getElementById("department").value,

            graduationYear:
                parseInt(
                    document.getElementById("graduationYear").value
                ),

            status: "ACTIVE"
        };


        try {

            const response = await fetch("/api/students", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(student)

            });


            const data = await response.json();


            if (response.ok) {

                alert(
                    "Student registered successfully! 🎉"
                );

                registrationForm.reset();

            } else {

                let errorMessage =
                    data.message ||
                    "Registration failed.";

                if (data.errors) {

                    errorMessage += "\n\n";

                    Object.values(data.errors).forEach(error => {

                        errorMessage +=
                            "• " + error + "\n";

                    });
                }

                alert(errorMessage);
            }


        } catch (error) {

            console.error(
                "Registration error:",
                error
            );

            alert(
                "Unable to connect to the server. " +
                "Please make sure CampusConnect is running."
            );
        }

    });

}