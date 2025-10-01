# RentMazing Apartment API

This project is a simple RESTful API built with Spring Boot for managing clients and their associated apartments. It serves as a practical example of building web services using the Spring ecosystem.

## Technology Stack

*   **Java 17**
*   **Spring Boot 3**: Core framework for building the application.
*   **Spring Web**: For creating RESTful APIs (`@RestController`).
*   **Spring Data JPA**: For simplifying database interactions.
*   **Hibernate**: The JPA implementation used for Object-Relational Mapping (ORM).
*   **H2 Database**: An in-memory database, perfect for development and testing.
*   **Maven**: For project build and dependency management.

## Prerequisites

Before you begin, ensure you have the following installed:
*   JDK 17 or later
*   Apache Maven

## How to Run the Application

1.  **Clone the repository** (if you are using a Git repository):
    ```bash
    git clone <your-repository-url>
    cd apartment
    ```

2.  **Run using Maven**:
    You can start the application by running the following command in the project's root directory:
    ```bash
    mvn spring-boot:run
    ```

3.  The application will start on port `8080`. You can access it at `http://localhost:8080`.

## Database

This project uses an **H2 in-memory database**.

*   The database schema is automatically created on startup based on the `src/main/resources/schema.sql` file.
*   The **H2 Console** is enabled to allow you to view and query the database directly from your browser.

### How to Log In to the H2 Console

1.  Once the application is running, navigate to `http://localhost:8080/h2-console` in your web browser.
2.  You will see a login page. Ensure the fields are filled out as follows:
    -   **Driver Class**: `org.h2.Driver`
    -   **JDBC URL**: `jdbc:h2:mem:rentmazingdb`
    -   **User Name**: `sa`
    -   **Password**: (leave this field blank)
3.  Click **Connect**. You can now browse the tables (`CLIENTS`, `CLIENT_APARTMENTS`) and run SQL queries.

## Available API Endpoints

The following endpoints are available:

| Method | Endpoint             | Description                               |
|:-------|:---------------------|:------------------------------------------|
| `GET`  | `/api/hello`         | A simple test endpoint to check if the API is running. |
| `GET`  | `/api/clients`       | Retrieves a list of all clients in the database.       |
| `GET`  | `/api/apartments`    | Retrieves a list of all apartments in the database.    |

## Project Structure

The project follows a standard layered architecture:

*   `controller`: Contains `ApartmentRestController` which defines the API endpoints and handles incoming HTTP requests.
*   `service`: Contains `ApartmentService` which holds the business logic.
*   `repository`: Contains `ClientRepository` and `ClientApartmentRepository` interfaces for data access using Spring Data JPA.
*   `entity`: Contains the `Client` and `ClientApartment` JPA entities that map to database tables.