# README for ToDo Application

This application is a simple ToDo list management system. It allows users to create, read, update, and delete ToDo
items. The application uses a REST API to allow clients to interact with the system. The API is implemented using Spring
Boot and Hibernate.

## Functionalities:

- Get all ToDo items: The API endpoint /todos returns all the ToDo items present in the system.
- Create a new ToDo item: The API endpoint /todos allows the user to create a new ToDo item by sending a POST request
  with the necessary details in the request body.
- Get completed ToDo items: The API endpoint /todos/completed returns all the completed ToDo items present in the
  system.
- Get deleted ToDo items: The API endpoint /todos/deleted returns all the deleted ToDo items present in the system.
- Get a specific ToDo item: The API endpoint /todos/{id} returns the details of a specific ToDo item identified by its
  ID.
- Update a specific ToDo item: The API endpoint /todos/{id} allows the user to update the details of a specific ToDo
  item identified by its ID.
- Delete a specific ToDo item: The API endpoint /todos/{id} allows the user to delete a specific ToDo item identified by
  its ID.
  Swagger:

The application uses Swagger to document the API endpoints and to provide a graphical interface for testing the
endpoints. To access the Swagger documentation, go to http://localhost:8080/swagger-ui/ in your web browser.

## Technologies:

### The application is built using the following technologies:

- Spring Boot: A framework for building Java applications.
- Hibernate: An ORM (Object-Relational Mapping) library that simplifies database access.
- JDBC/Postgres Database: A lightweight in-memory database used for development and testing.
- Swagger: A tool for documenting and testing REST APIs.
- Docker - For serving the application and database for quick access.
- Mockito/Junit for Testing
- Maven for build automation and dependencies.

## How to run the application:

Please ensure you have Java, Docker Desktop and Maven installed on your local machine.

### To run the application, follow these steps:

- Clone the repository to your local machine.
- Open a terminal window in the root directory of the project.
- Run the command ./mvnw clean package to build the application.
- Run the command docker-compose up to run the application and database via a docker container
- Open a web browser and go to http://localhost:8081/swagger-ui/index.html# to access the Swagger documentation and test
  the API endpoints.
