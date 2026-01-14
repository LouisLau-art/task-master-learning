package com.example.taskmaster.service.impl;

import com.example.taskmaster.entity.Task;
import com.example.taskmaster.mapper.TaskMapper;
import com.example.taskmaster.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Service Implementation.
 * 
 * It extends ServiceImpl<Mapper, Entity> which implements IService<Entity>.
 * This wires everything together.
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {
    
}
