-- Drop tables if they exist to ensure a clean slate on each startup
DROP TABLE IF EXISTS client_apartments;
DROP TABLE IF EXISTS clients;

-- Create the clients table based on the Client entity
CREATE TABLE clients (
    client_id UUID PRIMARY KEY,
    full_name VARCHAR(100) NULL,
    email VARCHAR(100) NULL,
    phone VARCHAR(16) NULL
);

-- Create the client_apartments table, inferred from the @OneToMany relationship
CREATE TABLE client_apartments (
    apartment_id UUID PRIMARY KEY,
    description VARCHAR(255),
    building_name VARCHAR(100) NULL,
    street_address VARCHAR(100) NULL,
    city VARCHAR(100) NULL,
    postal_code VARCHAR(10) NULL,
    is_available_for_rent BOOLEAN NULL,
    rent_price INTEGER NULL,
    client_id UUID REFERENCES clients
);