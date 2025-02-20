# Spring Framework Web Application

## Overview
This project is a web application built using the **Spring Framework**, designed with a simple UI but backed by a complex and well-structured architecture. It follows best practices in software development, ensuring security, maintainability, and scalability.

![image alt](https://github.com/anahorga/springboot-auth-events/blob/0035d94be8d293e3101f2b78a2a4b2c38f37a59d/Screenshot%202025-02-20%20140039.png)

![image alt](https://github.com/anahorga/springboot-auth-events/blob/0035d94be8d293e3101f2b78a2a4b2c38f37a59d/Screenshot%202025-02-20%20140156.png)

![image alt](https://github.com/anahorga/springboot-auth-events/blob/0035d94be8d293e3101f2b78a2a4b2c38f37a59d/Screenshot%202025-02-20%20140224.png)

## Features
- **Spring Boot** - Rapid development with embedded Tomcat.
- **Spring Security** - Implements authentication and authorization.
- **JWT Authentication** - Secures API endpoints.
- **Database Management** - Implements full **CRUD** operations.
- **Lombok Integration** - Reduces boilerplate code for data models.
- **DTO (Data Transfer Objects)** - Ensures clean separation between layers.
- **Service Layer Architecture** - Enhances maintainability and modularity.
- **Global Exception Handling** - Implements centralized error management.
- **Logging** - Uses SLF4J and Logback for application logging.
- **Environment Configuration** - Uses application properties for flexible setup.
- **Deployment on Railway** - The database is hosted and deployed on **Railway**.
- **BCrypt Password Encryption** - All passwords are securely encrypted.

## Technologies Used
- **Spring Boot** (Core Framework)
- **Spring Data JPA** (Database Interaction)
- **Spring Security** (Authentication & Authorization)
- **MySQL** (Database options)
- **Lombok** (Code Simplification)
- **JWT (JSON Web Token)** (Security)
- **Thymeleaf**
- **Maven** (Build and Dependency Management)


## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo.git
   cd your-repo
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=<RAILWAY_DATABASE_URL>
   spring.datasource.username=<USERNAME>
   spring.datasource.password=<PASSWORD>
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Security
- **BCrypt Encryption** ensures that user passwords are securely hashed.
- **JWT Tokens** are used for authentication and securing API endpoints.
- **Role-Based Access Control** restricts functionalities based on user roles.

## Deployment
The project is deployed using **Railway**, a cloud platform for hosting applications, ensuring scalability and easy database management.

## Contributing
Feel free to contribute by submitting pull requests or opening issues.

## License
This project is licensed under the MIT License.

---

_This repository is actively maintained. Contributions and feedback are welcome!_

