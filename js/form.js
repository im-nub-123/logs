<!DOCTYPE html>
<html>
<head>
    <title>Form Validation</title>
</head>

<body>

    <h2>Registration Form</h2>

    <form id="myForm">

        <label>Name:</label>
        <input type="text" id="name">
        <span id="nameError"></span>
        <br><br>

        <label>Email:</label>
        <input type="text" id="email">
        <span id="emailError"></span>
        <br><br>

        <label>Password:</label>
        <input type="password" id="password">
        <span id="passwordError"></span>
        <br><br>

        <label>Confirm Password:</label>
        <input type="password" id="confirmPassword">
        <span id="confirmPasswordError"></span>
        <br><br>

        <button type="submit">Submit</button>

    </form>

    <p id="successMessage"></p>


    <script>
        document.getElementById("myForm").addEventListener("submit", function(event) {

            event.preventDefault();

            // Get values
            const name = document.getElementById("name").value.trim();
            const email = document.getElementById("email").value.trim();
            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirmPassword").value;

            // Get error elements
            const nameError = document.getElementById("nameError");
            const emailError = document.getElementById("emailError");
            const passwordError = document.getElementById("passwordError");
            const confirmPasswordError = document.getElementById("confirmPasswordError");
            const successMessage = document.getElementById("successMessage");

            // Clear previous messages
            nameError.textContent = "";
            emailError.textContent = "";
            passwordError.textContent = "";
            confirmPasswordError.textContent = "";
            successMessage.textContent = "";

            let isValid = true;

            // Name validation
            if (name === "") {
                nameError.textContent = "Name cannot be empty.";
                isValid = false;
            }

            // Email validation
            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

            if (email === "") {
                emailError.textContent = "Email cannot be empty.";
                isValid = false;
            } else if (!emailPattern.test(email)) {
                emailError.textContent = "Please enter a valid email address.";
                isValid = false;
            }

            // Password validation
            if (password === "") {
                passwordError.textContent = "Password cannot be empty.";
                isValid = false;
            } else if (password.length < 8) {
                passwordError.textContent = "Password must be at least 8 characters long.";
                isValid = false;
            } else if (!/[A-Z]/.test(password)) {
                passwordError.textContent = "Password must contain at least one uppercase letter.";
                isValid = false;
            } else if (!/[0-9]/.test(password)) {
                passwordError.textContent = "Password must contain at least one number.";
                isValid = false;
            }

            // Confirm password validation
            if (confirmPassword === "") {
                confirmPasswordError.textContent = "Please confirm your password.";
                isValid = false;
            } else if (password !== confirmPassword) {
                confirmPasswordError.textContent = "Passwords do not match.";
                isValid = false;
            }

            // Final result
            if (isValid) {
                successMessage.textContent = "Form submitted successfully!";
            }

        });
    </script>

</body>
</html>
