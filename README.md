# 💰 Investor Withdrawal App

A backend REST API built with **Spring Boot** that streamlines the investor withdrawal process. The application manages investor information, investment products, and withdrawal requests while persisting data in a PostgreSQL database.

## 🌐 Project Repository

**GitHub:** https://github.com/MissTracy/InvestorWithdrawal_App

## ✨ Features

*  Manage investor records
* Retrieve investment products linked to investors
* Create withdrawal requests
* RESTful API architecture
* Data persistence with PostgreSQL
* Interactive API documentation with Swagger/OpenAPI
* Layered architecture using Controllers, Services, and Models

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
├── Configswagger
└── RunApp.java
```

## API Endpoints

### Investors

* `GET /api/investors/{id}` – Retrieve an investor by ID
* `GET /api/investors/{id}/products` – Retrieve an investor's products

### Products

* `GET /products/{investorId}/products` – Retrieve products for an investor
* `POST /products/create` – Create a new investment product

### Withdrawals

* `POST /api/withdrawals/{productId}/create` – Create a withdrawal request

## Key Learning Outcomes

This project strengthened my understanding of:

* Building RESTful APIs with Spring Boot
* MVC architecture
* Spring Data JPA
* Database integration with PostgreSQL
* CRUD operations
* Layered application design
* API documentation using Swagger/OpenAPI

## 📸 Preview

Since this is a backend application, API endpoints can be tested using:

* Swagger UI
* Postman
* Insomnia

## 👩🏽‍💻 Author

**Tracy Lethoko**

* GitHub: https://github.com/MissTracy
* Portfolio: https://tracylethoko.netlify.app
