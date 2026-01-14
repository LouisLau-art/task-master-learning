package com.example.taskmaster.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.taskmaster.common.Result;
import com.example.taskmaster.entity.Task;
import com.example.taskmaster.service.ITaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin // Allows all origins to access this controller
public class TaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Create a new task.
     * POST /api/tasks
     */
    @PostMapping
    public Result<Task> createTask(@jakarta.validation.Valid @RequestBody Task task) {
        if (task.getCompleted() == null) {
            task.setCompleted(false);
        }
        task.setCreatedAt(LocalDateTime.now());

        taskService.save(task);
        // Using our static factory method for cleaner code
        return Result.success(task);
    }

    /**
     * Get all tasks.
     */
    @GetMapping
    public Result<List<Task>> getAllTasks() {
        return Result.success(taskService.list());
    }

    /**
     * Get tasks with pagination.
     * GET /api/tasks/page?current=1&size=5
     */
    @GetMapping("/page")
    public Result<IPage<Task>> getTaskPage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size) {
        
        // Use the Page object provided by MyBatis Plus
        Page<Task> page = new Page<>(current, size);
        IPage<Task> taskPage = taskService.page(page);
        
        return Result.success(taskPage);
    }
}