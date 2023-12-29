package com.example.todoapi.task.request

import com.example.todoapi.task.enums.TaskPriority
import java.util.Date

data class TaskUpdateRequest(
    val name: String,
    val description: String,
    val priority: TaskPriority,
    val date: Date,
    val completed: Boolean
)
