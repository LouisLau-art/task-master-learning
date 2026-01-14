package com.example.taskmaster.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("task") // Maps to database table named 'task'
public class Task {

    /**
     * Primary Key.
     * IdType.AUTO: Database handles auto-increment.
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    @jakarta.validation.constraints.NotBlank(message = "任务标题不能为空")
    private String title;

    private String description;

    /**
     * Default false.
     * Note: In DB, this usually maps to TINYINT(1).
     */
    private Boolean completed;

    private LocalDateTime createdAt;
}
