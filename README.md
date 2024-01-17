# Placement Management Application

This is a Spring Boot application for managing colleges in a placement management system.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [Endpoints](#endpoints)

## Introduction

The Placement Management Application is designed to manage information about colleges. It provides basic CRUD operations for colleges, allowing users to add, update, retrieve, and delete college records.

## Technologies Used

- Java
- Spring Boot
- Jakarta Persistence API (JPA)
- Lombok
- Maven

## Setup

To run the application locally, make sure you have Java and Maven installed. Clone the repository and run the following commands:

```bash
mvn clean install
mvn spring-boot:run
```
## Usage

The application will be accessible at [http://localhost:9000](http://localhost:9000).

## Endpoints

### Add College

- **Endpoint:** `POST /colleges`
- **Request Body:** JSON representing college details (refer to `AddCollegeRequest` model)
- **Response:** JSON representing the added college

### Get College by ID

- **Endpoint:** `GET /colleges/{id}`
- **Response:** JSON representing the college with the specified ID

### Get All Colleges

- **Endpoint:** `GET /colleges`
- **Response:** JSON array representing all colleges

### Update College

- **Endpoint:** `POST /colleges/update/{id}`
- **Request Body:** JSON representing updated college details (refer to `AddCollegeRequest` model)
- **Response:** JSON representing the updated college

### Delete College

- **Endpoint:** `DELETE /colleges/{id}`
- **Response:** "College Deleted" if successful, or an error message if the college is not found
