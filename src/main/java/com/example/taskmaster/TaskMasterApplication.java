package com.example.taskmaster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.taskmaster.mapper") // CRITICAL: Tell MyBatis where the mappers are
public class TaskMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskMasterApplication.class, args);
	}

}
