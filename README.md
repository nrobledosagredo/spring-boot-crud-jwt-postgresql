# Spring Boot CRUD with PostgreSQL and Cognito Authentication
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Amazon AWS](https://img.shields.io/badge/Amazon_AWS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![Apache Maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)


## Overview

A Spring Boot API integrating with PostgreSQL, showcasing AWS Cognito authentication, and performing CRUD operations. This project was created for learning and demonstration purposes.

This project provides a simple item management system, demonstrating a basic REST API secured with JWT via AWS Cognito, and data persistence with PostgreSQL.

## Features

* **Spring Boot:** Built with Spring Boot for rapid application development.
* **PostgreSQL database:** Data persistence using a PostgreSQL database.
* **Cognito authentication:** Secure API endpoints using JWT tokens from AWS Cognito.
* **CRUD operations:** Create, read, update, and delete items.
* **User-specific data:** Items are associated with users, ensuring data isolation.

## Technologies

* **Spring Boot:** Java-based framework for building microservices.
* **Spring Security:** Security framework for authentication and authorization.
* **Spring Data JPA:** Simplifies database interactions.
* **PostgreSQL:** Relational database management system.
* **AWS Cognito:** User authentication and authorization service.
* **Maven:** Build automation tool.
* **Lombok:** Java library for reducing boilerplate code.

## Prerequisites

* Java 21
* Maven
* PostgreSQL database
* AWS Cognito user pool

## Setup

1.  **Clone the repository:**

    ```bash
    git clone [repository URL]
    cd spring-boot-crud-postgresql-cognito
    ```

2.  **Configure environment variables:**

    * Create a `.env` file in the project's root directory.
    * Add the following variables, replacing the placeholders with your actual values:

        ```properties
        DATABASE_URL=jdbc:postgresql://<your_db_host>:<your_db_port>/<your_db_name>
        DATABASE_USERNAME=<your_db_username>
        DATABASE_PASSWORD=<your_db_password>
        COGNITO_ISSUER=<your_cognito_issuer_url>
        COGNITO_JWKS_URI=<your_cognito_jwks_uri>
        CORS_ALLOWED_ORIGIN=* # or your front end url.
        ```

3.  **Build the project:**

    ```bash
    mvn clean install
    ```

4.  **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

5.  **Configure AWS Cognito:**
    * Create a Cognito user pool.
    * Configure the application to use your Cognito user pool.
    * Obtain a JWT token from Cognito for testing.

## API Endpoints

* **`POST /items`:** Create a new item (requires Cognito authentication).
* **`GET /items`:** Get all items for the authenticated user (requires Cognito authentication).
* **`GET /items/{id}`:** Get an item by ID (requires Cognito authentication).
* **`PUT /items/{id}`:** Update an item (requires Cognito authentication).
* **`DELETE /items/{id}`:** Delete an item (requires Cognito authentication).

## Testing

To test the API, you can use tools like Postman or curl. Remember to include the JWT token in the `Authorization` header of your requests.

Example (using curl):

```bash
curl -X GET \
    http://localhost:8080/items \
    -H 'Authorization: Bearer <your_cognito_token>'
