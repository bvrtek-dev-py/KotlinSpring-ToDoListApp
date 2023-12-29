package com.example.todoapi.task.repository

import com.example.todoapi.task.entity.Task
import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<Task, Long> {
}