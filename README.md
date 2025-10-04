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

*   The database schema is created on startup from `src/main/resources/schema.sql`.
*   The database is then populated with sample data from `src/main/resources/data.sql`.
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

The API supports the following endpoints for managing clients and apartments.

| Method | Endpoint                                   | Description                                                  |
|:-------|:-------------------------------------------|:-------------------------------------------------------------|
| `GET`  | `/api/hello`                               | A simple test endpoint to check if the API is running.       |
| `GET`  | `/api/clients`                             | Retrieves a list of all clients.                             |
| `GET`  | `/api/clients/{clientId}`                  | Retrieves a specific client by their UUID.                   |
| `GET`  | `/api/apartments`                          | Retrieves a list of all apartments with filtering options.   |
| `POST` | `/api/client`                              | Creates a new client and their associated apartments.        |

### Apartment Filtering Options

The `/api/apartments` endpoint supports the following query parameters for filtering:
*   `city={city}`: Filters apartments by city (case-insensitive).
*   `minPrice={number}` & `maxPrice={number}`: Filters apartments by a rent price range.
*   `isAvailableForRent={true|false}`: Filters apartments by availability.

## Testing the Endpoints

You can use `curl` to test the endpoints from your command line. Here are some examples based on the sample data:

```bash
# Get all clients
curl -i 'http://localhost:8080/api/clients'

# Create a new client
curl --location --request POST 'http://localhost:8080/api/client' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fullName": "Diana Prince",
    "email": "diana.prince@mail.com",
    "phone": "777-7777",
    "apartments": [
        {
            "description": "Diana Prince building 1",
            "buildingName": "Athens Temple",
            "streetAddress": "Athens Ancient Street 7",
            "city": "Athens",
            "postalCode": "777111",
            "rentPrice": 399861,
            "availableForRent": false
        }
    ]
}'

# Get a specific client by ID
curl -i 'http://localhost:8080/api/clients/87009ba1-6da8-431a-8ff9-73182d506e6d'

# Filter apartments by city (case-insensitive)
curl -i 'http://localhost:8080/api/apartments?city=gotham'

# Filter apartments by price range
curl -i 'http://localhost:8080/api/apartments?minPrice=100000&maxPrice=150000'
```

## Project Structure

The project follows a standard layered architecture:

*   `controller`: Contains `ApartmentRestController` which defines the API endpoints and handles incoming HTTP requests.
*   `service`: Contains `ApartmentService` which holds the business logic.
*   `repository`: Contains `ClientRepository` and `ClientApartmentRepository` interfaces for data access using Spring Data JPA.
*   `entity`: Contains the `Client` and `ClientApartment` JPA entities that map to database tables.