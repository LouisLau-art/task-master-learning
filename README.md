# Task Master Learning

A professional Task Management application built with a modern full-stack architecture. This project serves as a comprehensive learning journey to master **Spring Boot 3** and **Vue 3** integration.

## 🚀 Key Features

- **Standardized REST API**: Consistent `{code, message, data}` response structure.
- **Physical Pagination**: Efficient data fetching using MyBatis Plus pagination interceptor.
- **Robust Validation**: Server-side input validation with custom error handling.
- **Modern Frontend**: Built with Vue 3 (Composition API), TypeScript, and Vite.
- **Spec-Driven Development**: All features are implemented following a strict specification-and-plan workflow.

## 🛠️ Tech Stack

### Backend
- **Java 21**
- **Spring Boot 3.2.0**
- **MyBatis Plus** (Database access)
- **H2 Database** (In-memory, zero config)
- **Lombok** (Boilerplate reduction)
- **Jakarta Validation**

### Frontend
- **Vue 3** (Script Setup + TypeScript)
- **Vite** (Build tool)
- **Axios** (HTTP Client)
- **Bun** (Package manager & runtime)

## 🏁 Getting Started

### Prerequisites
- JDK 17 or 21
- Maven 3.x
- Bun (or Node.js 18+)

### Backend Setup
1. Open the project root.
2. Run `mvn spring-boot:run`.
3. API will be available at `http://localhost:8081`.
4. H2 Console: `http://localhost:8081/h2-console` (JDBC URL: `jdbc:h2:mem:taskdb`).

### Frontend Setup
1. `cd frontend`
2. `bun install`
3. `bun dev`
4. Access the UI at `http://localhost:5173`.

## 📜 License
Distributed under the MIT License. See `LICENSE` for more information.
