package com.example.taskmaster.mapper;

import com.example.taskmaster.entity.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper Interface.
 * 
 * By extending BaseMapper<Task>, we get basic CRUD operations for free:
 * - insert
 * - deleteById
 * - updateById
 * - selectById
 * - selectList
 * ... and more.
 */
@Mapper
public interface TaskMapper extends BaseMapper<Task> {
    // No need to write any SQL here for basic operations!
}
