# Feature Specification: Backend Standardization

**Feature Branch**: `02-backend-standardization`  
**Created**: 2026-01-13  
**Status**: Draft  
**Goal**: Transition from a "toy" API to a professional, standardized REST API.

## User Scenarios & Testing

### User Story 1 - Standardized Response (Priority: P1)
As a Frontend developer, I want all API responses to follow the same structure `{code, message, data}` so I can write consistent error handling logic.

**Acceptance Criteria**:
- All endpoints return a JSON object containing `code`, `message`, and `data`.
- For success, `code` is 200.

### User Story 2 - Paginated Task List (Priority: P1)
As a user with many tasks, I want to see only a portion of my tasks at a time (e.g., 10 per page) so the application remains fast.

**Acceptance Criteria**:
- `GET /api/tasks/page` accepts `current` and `size` parameters.
- Response includes total count, current page, and the list of tasks.

### User Story 3 - Basic Input Validation (Priority: P2)
As a system, I want to prevent tasks with empty titles from being saved to the database.

**Acceptance Criteria**:
- `POST /api/tasks` returns a 400-level error if `title` is empty.

## Requirements

### Functional Requirements
- **FR-001**: Implement a generic `Result<T>` wrapper class.
- **FR-002**: Configure MyBatis Plus Pagination Inner Interceptor.
- **FR-003**: Add `spring-boot-starter-validation` dependency.
- **FR-004**: Implement a Global Exception Handler to catch and format errors.

## Success Criteria
- **SC-001**: `curl GET /api/tasks/page?current=1&size=2` returns a structured JSON with exactly 2 items (if enough data exists).
- **SC-002**: `curl POST` with empty title returns a JSON error message instead of a stack trace.
