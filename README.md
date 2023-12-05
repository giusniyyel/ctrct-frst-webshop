# Contract First Webshop Api

This project is a Spring Boot API developed using a contract-first approach, with PostgreSQL as the database. Follow the
steps below to set up and run the application.

## Project Overview

This project aims to create a RESTful web service using the Spring Web and Spring Data frameworks. We'll be following a
contract-first approach, and Gradle will be our build tool of choice. To add a practical touch, we'll integrate entities
from the PostgreSQL Sample Database.

### Objectives

1. **RESTful Web Service**: Build a web service that adheres to REST principles, allowing for easy communication and
   integration.

2. **Contract-First Approach**: Embrace a contract-first methodology, ensuring clear specifications and seamless
   collaboration between teams.

3. **Spring Web and Spring Data**: Leverage the power of Spring Web for creating web applications and Spring Data for
   simplified data access.

4. **Gradle Build Tool**: Utilize Gradle to automate the build process, making project management and dependency
   resolution straightforward.

5. **PostgreSQL Sample Database**: Incorporate entities from the PostgreSQL Sample Database to enhance real-world
   applicability.

### Getting Started

Follow the provided instructions in the README.md file to set up the project on your local machine. This includes
creating a PostgreSQL database, importing necessary SQL files, configuring data sources, and running the application.

### Usage

Once set up, the application will expose RESTful endpoints. Access the provided API documentation to understand
available endpoints and start interacting with the web service.

### Note

This project's simplicity and clarity make it an ideal starting point for learning and implementing RESTful web services
with Spring. Feel free to explore, experiment, and adapt the codebase to suit your specific requirements.

## Prerequisites

- Java JDK 8 or later
- PostgreSQL Database Server
- PgAdmin application (optional but recommended for easier database management)
- IntelliJ IDEA (or any other preferred Java IDE)

## Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/your-project.git
    ```

2. Open the project in IntelliJ IDEA.

3. Create a PostgreSQL database on your local machine. You can use

   ```bash
   createdb -U postgres -e projects
   ```

4. Import the database schema using the `project.sql` file in the `sql` folder:

    - Using Terminal:
        - Use the following command.
        ```bash
        psql -U postgres -d globant -f project.sql
        ```
    - Using PgAdmin:
        - Open PgAdmin and connect to your PostgreSQL server.
        - Right-click on the newly created database.
        - Choose "Restore..."
        - Select the `project.sql` file from the `sql` folder.
        - Execute the restore.

5. Import data into the `customer` table:

    - Using PgAdmin:
        - Right-click on the `customer` table.
        - Choose "Import/Export..."
        - Select the `customer.csv` file.
        - Follow the import wizard to complete the process.

6. Modify the `application.properties` file in the `src/main/resources` folder:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your-database-name
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

   > Update the values with your database details.

## Run the Application

1. Open the `CtrctFrstWebshopApplication.java` file in IntelliJ.

2. Run the application. This will start the Spring Boot server.

3. Access the API at [http://localhost:8080/api/v1/customers](http://localhost:8080/api/v1/customers).

## Usage

You can now start sending information or making requests to the API.

### Example API Endpoints

- **GET:** [http://localhost:8080/api/v1/customers](http://localhost:8080/api/v1/customers)
- **POST:** [http://localhost:8080/api/v1/customers](http://localhost:8080/api/v1/customers)

Feel free to explore other API endpoints as per your application's functionality.

---
Typed with ❤️ by [Daniel Campos](https://github.com/giusniyyel) 😊
Licensed under the Apache 2.0 License.