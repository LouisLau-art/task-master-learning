# Implementation Plan: Backend Standardization

**Feature**: Backend Standardization (Result, Pagination, Validation)
**Spec**: `specs/02-backend-standardization.md`

## 1. Dependencies Update
- Add `spring-boot-starter-validation` to `pom.xml`.

## 2. Component Implementation

### 2.1 Unified Response Class (`Result<T>`)
- Create `com.example.taskmaster.common.Result<T>`.
- Methods: `success(T data)`, `error(String message)`.

### 2.2 Pagination Configuration
- Create `com.example.taskmaster.config.MyBatisPlusConfig`.
- Add `MybatisPlusInterceptor` with `PaginationInnerInterceptor`.

### 2.3 Global Exception Handler
- Create `com.example.taskmaster.common.GlobalExceptionHandler`.
- Use `@RestControllerAdvice` to catch exceptions and return `Result.error()`.
- **Why?** To avoid showing raw stack traces to users/frontend.

### 2.4 Update Controller
- Modify `TaskController` to return `Result<...>` instead of raw objects.
- Add `@Valid` to the `createTask` parameter.
- Add `getPage` endpoint.

## 3. Verification
1. Test success response format.
2. Test pagination with `current` and `size` params.
3. Test empty title validation.
