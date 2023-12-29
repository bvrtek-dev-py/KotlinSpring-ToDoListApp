package com.example.todoapi.task.request

import com.example.todoapi.task.enums.TaskPriority
import java.util.Date

data class TaskCreateRequest(
    val name: String,
    val priority: TaskPriority,
    val date: Date,
    val description: String
)
