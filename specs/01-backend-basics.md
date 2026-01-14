# Feature Specification: Backend Foundation and Task Creation

**Feature Branch**: `01-backend-basics`  
**Created**: 2026-01-13  
**Status**: Draft  
**Input**: Setup Spring Boot 3 project and implement Task creation.

## User Scenarios & Testing (mandatory)

### User Story 1 - Create a new Task (Priority: P1)

As a user, I want to be able to create a new task with a title and description so that I can keep track of things I need to do.

**Why this priority**: This is the most fundamental action of the system. Without creating data, there is nothing to manage.

**Independent Test**: Can be tested by sending a POST request to `/api/tasks` with JSON data and verifying a `201 Created` response.

**Acceptance Scenarios**:

1. **Given** the backend is running, **When** I send a POST request with `{"title": "Learn Spring Boot", "description": "Finish the first lesson"}`, **Then** I should receive a JSON object with an assigned `id` and `completed: false`.
2. **Given** the backend is running, **When** I send a POST request with an empty title, **Then** the system should return a `400 Bad Request` error.

## Requirements (mandatory)

### Functional Requirements

- **FR-001**: System MUST be initialized with Spring Boot 3.x and Java 17.
- **FR-002**: System MUST use an H2 in-memory database for rapid development.
- **FR-003**: System MUST expose a REST API endpoint `POST /api/tasks`.
- **FR-004**: System MUST validate that `title` is not null or empty.
- **FR-005**: System MUST automatically set `completed` to `false` and `createdAt` to the current time for new tasks.

### Key Entities

- **Task**:
    - `id`: Long, unique identifier (Primary Key).
    - `title`: String, mandatory.
    - `description`: String, optional.
    - `completed`: Boolean, default false.
    - `createdAt`: LocalDateTime, automatically assigned.

## Success Criteria (mandatory)

### Measurable Outcomes

- **SC-001**: The backend project starts without errors.
- **SC-002**: A task can be created via a REST client (like curl) in less than 500ms.
- **SC-003**: Data is persisted in the H2 database (verifiable during the session).
