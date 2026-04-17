# Supermarket Employee Manager API

A simple REST API for managing supermarket employees, built with Spring Boot.  
The project uses JPA for persistence, PostgreSQL as the database, Flyway for migrations, and follows a layered architecture.

---

## Features

- CRUD operations for employees
- Layered architecture (Controller, Service, Repository)
- PostgreSQL database integration
- Flyway database migrations
- Spring Data JPA (Hibernate)
- RESTful API design

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Flyway
- Maven

---

## Architecture

The project follows a clean layered architecture:

##Controller → Service → Repository → Database

- Controller: Handles HTTP requests
- Service: Business logic layer
- Repository: Data access layer (JPA)
- Entity: Database models

- Controller: Handles HTTP requests
- Service: Business logic layer
- Repository: Data access layer (JPA)
- Entity: Database models

---

## Database Configuration

Update `application.properties`:
```
properties
spring.datasource.url=jdbc:postgresql://localhost:5432/supermarket_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

spring.flyway.enabled=true
```
###Running the Project
##1. Clone the repository

```git clone https://github.com/your-username/supermarket-employee-manager.git
cd supermarket-employee-manager
```
##2. Run with Maven
```mvn spring-boot:run```
##API Endpoints

Employees
Method	Endpoint	Description
GET	/employees	List all employees
GET	/employees/{id}	Get employee by ID
POST	/employees	Create employee
PUT	/employees/{id}	Update employee
DELETE	/employees/{id}	Delete employee

##Example Request
```
{
  "name": "John Doe",
  "position": "Cashier",
  "salary": 1500.00
}
```
##Future Improvements
- Spring Security (JWT authentication)
- Swagger/OpenAPI documentation
- Pagination and filtering
- Unit and integration tests
- Docker support

###Author

````Raíssa Matos````




