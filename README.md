# Event Registration System

A full-stack Event Registration System built using Spring Boot, Hibernate, MySQL, and JavaScript that allows users to browse events and register while providing admin functionality for event management.

---

## Features

### User Features

- View available events
- Register for events
- Responsive and dynamic UI
- Registration modal system

### Admin Features

- Create events
- View events
- Delete events
- Manage event listings

### Backend Features

- REST APIs using Spring Boot
- MySQL database integration
- Hibernate / JPA ORM
- Validation using Jakarta Validation
- Pagination support
- Event search functionality
- Duplicate registration prevention
- Event capacity validation
- Layered architecture

---

## Tech Stack

### Backend

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- MySQL

### Frontend

- HTML
- CSS
- JavaScript

### Database

- MySQL

---

## Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
├── resources
│   └── static
```

---

## Database Relationships

### Event → Registration

```
One Event
    ↓
Many Registrations
```

### User → Registration

```
One User
    ↓
Many Registrations
```

---

## API Endpoints

### Events

### Create Event

```
POST /events
```

### Get Events

```
GET /events
```

### Get Event By ID

```
GET /events/{id}
```

### Update Event

```
PUT /events/{id}
```

### Delete Event

```
DELETE /events/{id}
```

---

### Registrations

### Register User

```
POST /registrations
```

### Cancel Registration

```
DELETE /registrations/{id}
```

---

## Pagination & Search

### Pagination

```
GET /events?page=0&size=5
```

### Search

```
GET /events?keyword=hackathon
```

---

## Business Rules Implemented

- Prevent duplicate registrations
- Prevent registrations when capacity is full
- Validate incoming requests
- Proper exception handling
- Pagination support
- Search functionality

---

## How To Run

### Clone Repository

```bash
git clone <repo-url>
```

### Configure Database

Update:

```
application.properties
```

Add:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eventdb

spring.datasource.username=root

spring.datasource.password=YOUR_PASSWORD
```

### Run Project

```bash
mvn spring-boot:run
```

Open:

```
http://localhost:8080
```

---

## Learning Outcomes

This project demonstrates:

- Backend architecture
- REST API development
- Database design
- Layered architecture
- Validation and exception handling
- Pagination and search
- Hibernate / JPA usage
- Business logic implementation
- Real-world backend workflows

---

## Future Improvements

- Authentication / Authorization
- Email notifications
- Docker deployment
- Cloud deployment
- Admin dashboard improvements

---

## Author
kalyani jadhao
(Built for learning backend development and internship purpose.)