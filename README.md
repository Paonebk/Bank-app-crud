
# Customer API - Spring Boot

This project provides a RESTful API for managing customers using Spring Boot. Below are instructions for testing the API using **Postman**.

---

## 🧪 How to Use Postman

1. Open Postman.
2. Create a new request tab for each operation below.
3. Set the request method (GET, POST, PUT, DELETE).
4. Enter the URL (e.g., `http://localhost:8080/api/customers`).
5. For POST and PUT, go to the **Body** tab, select **raw**, and choose **JSON** format.
6. Paste the JSON payload and click **Send**.

---

## 1. Create a Customer

- **Method:** POST
- **URL:** `http://localhost:8080/api/customers`
- **Body (raw JSON):**


{
"firstName": "John",
"lastName": "Doe",
"email": "john.doe@example.com",
"phoneNumber": "1234567890"
}

## 2. Get All Customers

- **Method:** GET
- **URL:** http://localhost:8080/api/customers

## 3. Get Customer by ID

- **Method:** GET
- **URL:** http://localhost:8080/api/customers/1


## 4. Update a Customer

- **Method:** PUT
- **URL:** http://localhost:8080/api/customers/1
- **Body (raw JSON):**
{
"firstName": "Jane",
"lastName": "Smith",
"email": "jane.smith@example.com",
"phoneNumber": "9876543210"
}
## 5. Delete a Customer

- **Method:** DELETE
- **URL:** http://localhost:8080/api/customers/1

