# 💰 Investor Withdrawal App

A backend REST API built with **Spring Boot** for managing investors, investment products, and withdrawal requests, with PostgreSQL persistence and business-rule validation

🔄 Project Update

This project was originally developed using an older Swagger/Springfox implementation. It was subsequently updated to use Springdoc OpenAPI to maintain compatibility with the current Spring Boot setup, while also refining the API endpoints and withdrawal functionality.

## ▶️ How to Run
Prerequisites: 

*Java 17
*PostgreSQL
*Maven


Steps: 
* Clone the repository:
* git clone https://github.com/MissTracy/InvestorWithdrawal_App.git
* cd InvestorWithdrawal_App
* Configure the PostgreSQL database connection in src/main/resources/application.properties.
* Start the application:
* ./mvnw spring-boot:run

Open Swagger UI:
http://localhost:8088/swagger-ui/index.html

The REST API can then be tested through Swagger UI.

## 🌐 Project Repository


## ✨ Features

* Manage investor records
* Retrieve investment products linked to investors
* Create withdrawal requests
* Validate withdrawal amounts and product balances
* Apply retirement withdrawal eligibility rules
* Retrieve withdrawal records for a specific investor
* RESTful API architecture
* Data persistence with PostgreSQL
* Interactive API documentation with Swagger/OpenAPI
* Layered architecture using Controllers, Services, and Models
* Separate `WithdrawalRequest` model for handling API request data

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Swagger / OpenAPI
* REST APIs

## 📂 Project Structure

```text
src
├── Controllers
├── Services
├── Models
├── repos
├── Configswagger
└── RunApp.java
```

## API Endpoints

### Investors

* `GET /investors/{id}` – Retrieve an investor by ID

### Products

* `GET /products/{investorId}` – Retrieve products linked to an investor
* `POST /products/create` – Create a new investment product

### Withdrawals

* `POST /withdrawals/{productId}` – Create a withdrawal request
* `GET /withdrawals/investor/{investorId}` – Retrieve all withdrawal belonging to an investor

## Technical Implementation

*REST API development with Spring Boot
*Spring Data JPA and PostgreSQL integration
*Layered Controller/Service/Repository architecture
*DTO-style request handling
*Business-rule validation
*CRUD operations
*Swagger/OpenAPI API documentation

## 📸 Preview

Since this is a backend application, API endpoints can be tested using:

* Swagger UI
* Postman

