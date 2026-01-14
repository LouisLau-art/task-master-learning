package com.example.taskmaster.service;

import com.example.taskmaster.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Service Interface.
 * 
 * Extending IService<Task> adds another layer of convenience methods
 * on top of the Mapper.
 */
public interface ITaskService extends IService<Task> {
    // We can add custom business methods here later.
}
