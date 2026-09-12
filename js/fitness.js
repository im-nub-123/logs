<!DOCTYPE html>
<html>
<head>
    <title>Muscle Magic - Customer Management</title>
</head>
<body>

    <h2>Muscle Magic</h2>

    <label>Name:</label>
    <input type="text" id="name"><br><br>

    <label>Email:</label>
    <input type="email" id="email"><br><br>

    <label>Age:</label>
    <input type="number" id="age"><br><br>

    <label>Height:</label>
    <input type="number" id="height"><br><br>

    <label>Weight:</label>
    <input type="number" id="weight"><br><br>

    <button onclick="addCustomer()">Submit</button>

    <h3>Customer Details</h3>

    <div id="customerTable"></div>


    <script>
        // Global array to store customer objects
        let customers = [];

        function addCustomer() {
            // Create customer object
            const customer = {
                name: document.getElementById("name").value,
                email: document.getElementById("email").value,
                age: document.getElementById("age").value,
                height: document.getElementById("height").value,
                weight: document.getElementById("weight").value
            };

            // Add object to global array
            customers.push(customer);

            // Display customers
            displayCustomers();

            // Clear input fields
            document.getElementById("name").value = "";
            document.getElementById("email").value = "";
            document.getElementById("age").value = "";
            document.getElementById("height").value = "";
            document.getElementById("weight").value = "";
        }

        function displayCustomers() {
            let table = `
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Age</th>
                        <th>Height</th>
                        <th>Weight</th>
                    </tr>
            `;

            customers.forEach(function(customer) {
                table += `
                    <tr>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.age}</td>
                        <td>${customer.height}</td>
                        <td>${customer.weight}</td>
                    </tr>
                `;
            });

            table += `</table>`;

            document.getElementById("customerTable").innerHTML = table;
        }
    </script>

</body>
</html>
