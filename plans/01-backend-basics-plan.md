# Implementation Plan: Backend Foundation with MyBatis Plus

**Feature**: Backend Foundation and Task Creation  
**Spec**: `specs/01-backend-basics.md`  
**Tech Stack**: Spring Boot 3, MyBatis Plus, H2 Database, Lombok

## 1. Project Dependencies (`pom.xml`)

We need to configure Maven to download the necessary "jars".

- **Core**: `spring-boot-starter-web` (for REST API)
- **Database**: `mybatis-plus-spring-boot3-starter` (The magic wrapper), `h2` (In-memory DB)
- **Tools**: `lombok` (Reduces boilerplate code)

## 2. Configuration (`src/main/resources/application.yml`)

Instead of `.properties`, we will use `.yml` which is more readable.

- Configure H2 database connection.
- Enable H2 Console (so we can see the data in browser).
- **Crucial**: Configure MyBatis Plus to print SQL logs (essential for learning!).

## 3. Implementation Steps

### Step 3.1: The Data Model (Entity)
**File**: `src/main/java/com/example/taskmaster/entity/Task.java`
- Use `@Data` for getters/setters.
- Use `@TableName("task")` to map to DB table.
- Use `@TableId(type = IdType.AUTO)` for the ID.

### Step 3.2: The Data Access Layer (Mapper)
**File**: `src/main/java/com/example/taskmaster/mapper/TaskMapper.java`
- Interface extending `BaseMapper<Task>`.
- **Note**: This empty interface gives us all CRUD methods for free!

### Step 3.3: The Business Logic (Service)
**Files**: 
- `src/main/java/com/example/taskmaster/service/ITaskService.java`
- `src/main/java/com/example/taskmaster/service/impl/TaskServiceImpl.java`
- Extend `IService<Task>` and `ServiceImpl<TaskMapper, Task>`.
- This is standard MyBatis Plus practice.

### Step 3.4: The API Layer (Controller)
**File**: `src/main/java/com/example/taskmaster/controller/TaskController.java`
- Annotated with `@RestController` and `@RequestMapping("/api/tasks")`.
- **Endpoint**: `POST /` to create a task.
- Should call `taskService.save(task)`.

### Step 3.5: Main Application
**File**: `src/main/java/com/example/taskmaster/TaskMasterApplication.java`
- Standard Spring Boot entry point.
- Add `@MapperScan("com.example.taskmaster.mapper")` so MP can find our mappers.

## 4. Verification Plan

1. Run the application.
2. Check H2 Console at `http://localhost:8080/h2-console`.
3. Send POST request via `curl` or Postman.
4. Verify data appears in H2 Console.
