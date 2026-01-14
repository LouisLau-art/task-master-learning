# Project Constitution: Task Master Learning

## 1. Mission
Build a robust "Task Manager" application to master the integration of Spring Boot 3 and Vue 3. The primary goal is educational: "Learning by Doing."

## 2. Technology Stack
- **Backend**:
  - Language: Java 17+
  - Framework: Spring Boot 3.x
  - Database: H2 (In-memory for easy setup) or SQLite
  - Build Tool: Maven (standard and verbose for learning)
  - API Style: RESTful
- **Frontend**:
  - Framework: Vue 3 (Composition API & `<script setup>`)
  - Build Tool: Vite
  - HTTP Client: Axios
  - CSS: Plain CSS or minimal Bootstrap/Tailwind (keep focus on logic)

## 3. Architecture Principles
- **Separation of Concerns**: Strictly separate Backend (API) and Frontend (UI).
- **Simplicity First**: Do not over-engineer. Use standard entity-controller-service patterns.
- **Spec-Driven**:
  1. Define the feature (Spec).
  2. Plan the implementation (Plan).
  3. Write the code (Implement).
- **Educational Code**:
  - Comments should explain *why*, not just *what*.
  - Prefer explicit code over "magic" annotations where helpful for understanding.

## 4. Core Data Model
**Task**
- `id`: Long (Auto-increment)
- `title`: String (Not null)
- `description`: String
- `completed`: Boolean (Default false)
- `createdAt`: DateTime
