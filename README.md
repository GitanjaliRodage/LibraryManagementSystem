# Library Management System

A Spring Boot CRUD REST API for managing books in a library.

## Technologies Used

- Java 26
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven
- Postman

## Features

- Add Book
- Get All Books
- Get Book By ID
- Update Book
- Delete Book
- ISBN Duplicate Validation
- Custom Exception Handling
- MySQL Database Integration

## Book Fields

- UUID id
- bookName
- author
- price
- quantity
- isbn
- available
- copies
- borrower

## API Endpoints

### Create Book
POST /books

### Get All Books
GET /books

### Get Book By ID
GET /books/{id}

### Update Book
PUT /books/{id}

### Delete Book
DELETE /books/{id}

## Database

Database Name:

librarydb

## Run Project

1. Clone repository
2. Configure MySQL in application.properties
3. Run LibraryManagementSystemApplication
4. Test APIs using Postman

## Author

Gitanjali Rodage