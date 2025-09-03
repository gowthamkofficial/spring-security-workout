# Spring Security Workout

A Spring Boot project demonstrating **Spring Security with JWT (JSON Web Token)** authentication and authorization.  
**Login** and **Registration** endpoints are **public**, while all **User CRUD** endpoints are **secured** and require a valid JWT.  
This project uses **PostgreSQL** as the database.

---

## ✨ Features

- **JWT Authentication & Authorization**
  - Public: `POST /api/auth/register`, `POST /api/auth/login`
  - Secured: all `/api/user/**` endpoints require `Authorization: Bearer <token>`
- **User CRUD**
  - List all users, view by ID, update, delete
- **Spring Security**
  - Custom `UserDetailsService`
  - BCrypt password hashing
  - Stateless authentication with JWT
- **Swagger Documentation**
  - Interactive API testing with JWT authorization button
- **PostgreSQL Integration**
  - JPA/Hibernate with PostgreSQL driver

---

## 🛠 Tech Stack

- **Backend:** Spring Boot 3+, Spring Security, Spring Web
- **Auth:** JWT (jjwt)
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA / Hibernate
- **API Docs:** Springdoc OpenAPI / Swagger UI
- **Build Tool:** Maven

---


🔑 API Endpoints
Public (No Auth)

POST /api/auth/register → Register a new user

POST /api/auth/login → Login and receive JWT

Secured (Require JWT)

GET /api/user → List all users

GET /api/user/{id} → Get user by ID

PUT /api/user/{id} → Update user

DELETE /api/user/{id} → Delete user

