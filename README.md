# DormFlow — Hostel Management System

## Project Introduction

**DormFlow** is a web-based hostel management system designed to simplify and centralize hostel operations for administrators, wardens, and students.

The system aims to manage student information, hostels, rooms, room allocations, attendance, leave workflows, and hostel entry/exit activities through a centralized platform.

DormFlow is currently under active development. The backend is being developed using **Spring Boot** with **PostgreSQL**, while the React-based frontend and additional system modules are being developed progressively.

---

## Project Status

DormFlow is an **ongoing project**. The core backend architecture and database foundation have been established, with additional business modules and system features currently under development.

| Area                             | Status         |
| -------------------------------- | -------------- |
| Spring Boot backend architecture | ✅ Implemented  |
| PostgreSQL database design       | ✅ Implemented  |
| JPA entities & relationships     | ✅ Implemented  |
| Repository layer                 | ✅ Implemented  |
| REST API foundation              | ✅ Implemented  |
| Global exception handling        | ✅ Implemented  |
| Student management               | 🚧 In Progress |
| Hostel & room management         | 🚧 In Progress |
| Room allocation & reallocation   | 🚧 In Progress |
| Audit/logging                    | 🚧 In Progress |
| AWS S3 profile image storage     | 📋 Planned     |
| JWT authentication               | 📋 Planned     |
| Role-based access control        | 📋 Planned     |
| Attendance & leave workflows     | 📋 Planned     |
| React.js frontend                | 📋 Planned     |
| Role-specific dashboards         | 📋 Planned     |
| WebSocket notifications          | 📋 Planned     |
| Advanced search & filtering      | 📋 Planned     |
| CI/CD & deployment               | 📋 Planned     |

---

## Features

### Currently Implemented

* Student, hostel, and room data management
* RESTful API architecture
* PostgreSQL database integration
* Spring Data JPA for persistence
* Entity relationships and database constraints
* Repository-based data access
* Global exception handling

### In Development

* Student management workflows
* Hostel and room management workflows
* Room allocation and reallocation
* Core hostel management business logic
* Entry/exit state management
* Audit-based tracking of important system changes
* Student profile image storage using AWS S3
* Additional hostel business rules and validations

### Planned

* JWT-based authentication
* Role-based authorization
* Student attendance management
* Leave request and approval workflows
* React.js frontend
* Role-specific dashboards
* Real-time notifications using WebSockets
* Advanced search and filtering
* Automated CI/CD pipeline
* Application deployment

---

## User Roles

DormFlow is designed around three primary user roles.

### Admin

Responsible for system-level management and administrative operations.

* Manage system users
* Manage hostel-related configuration
* Monitor overall hostel operations
* Manage administrative functions

### Warden

Responsible for day-to-day hostel management.

* View and manage students assigned to their hostel
* Manage rooms and room availability
* Assign rooms to students
* Reallocate students when required
* Manage hostel attendance and leave workflows
* Monitor student entry/exit activities

### Student

Provides students with access to their own hostel information and workflows.

* Register and maintain personal information
* View assigned hostel, floor, and room
* View allocation information
* Manage/view leave-related information
* View attendance and entry/exit information
* Receive system notifications

---

## Technology Stack

### Backend

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **REST APIs**
* **Maven**

### Database

* **PostgreSQL**

### Frontend

* **React.js**
* **JavaScript / TypeScript**
* **Tailwind CSS**

### Storage

* **AWS S3** — planned for secure student profile image storage

### Authentication & Communication

* **JWT** — planned for authentication and authorization
* **WebSockets** — planned for real-time notifications

### Development & Version Control

* **Git**
* **GitHub**
* **GitHub Actions** — planned for CI/CD

---

## Architecture

DormFlow follows a layered backend architecture designed to separate API handling, business logic, data access, and persistence.

### Current / Target Architecture

```text
                    ┌──────────────────────┐
                    │    React Frontend    │
                    │      (Planned)       │
                    └──────────┬───────────┘
                               │
                            REST API
                               │
                    ┌──────────▼───────────┐
                    │     Controllers      │
                    │   HTTP / API Layer   │
                    └──────────┬───────────┘
                               │
                    ┌──────────▼───────────┐
                    │      Services        │
                    │   Business Logic     │
                    └──────────┬───────────┘
                               │
                    ┌──────────▼───────────┐
                    │    Repositories      │
                    │    Data Access       │
                    └──────────┬───────────┘
                               │
                    ┌──────────▼───────────┐
                    │     PostgreSQL       │
                    │       Database       │
                    └──────────────────────┘

                         Additional Services
                    ┌───────────────────────┐
                    │ AWS S3  - Planned     │
                    │ WebSockets - Planned  │
                    │ JWT Auth - Planned    │
                    └───────────────────────┘
```

The backend follows the separation of concerns principle:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

* **Controllers** handle HTTP requests and responses.
* **Services** contain application and business logic.
* **Repositories** handle database operations through Spring Data JPA.
* **Entities** represent the persistent domain model.
* **DTOs** are used to control data exchanged through APIs.
* **Exception handling** provides centralized handling of application errors.

---

## Backend Structure

The Spring Boot backend is organized into separate layers based on their responsibilities.

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── dormflow/
    │           ├── controller/
    │           ├── service/
    │           ├── repository/
    │           ├── entity/
    │           ├── dto/
    │           ├── exception/
    │           └── config/
    │
    └── resources/
        └── application.properties
```

### Package Responsibilities

| Package      | Responsibility                                           |
| ------------ | -------------------------------------------------------- |
| `controller` | Handles REST API requests and responses                  |
| `service`    | Contains business logic and application workflows        |
| `repository` | Provides database access using Spring Data JPA           |
| `entity`     | Contains JPA entities representing the domain model      |
| `dto`        | Defines objects used for API request/response data       |
| `exception`  | Contains custom exceptions and global exception handling |
| `config`     | Contains application and framework configuration         |
| `resources`  | Contains application configuration and other resources   |

The backend structure is designed to remain modular as DormFlow expands with authentication, attendance, leave management, notifications, and other planned features.
