package com.example.todoapi.task.response

import com.example.todoapi.task.entity.Task
import com.example.todoapi.task.enums.TaskPriority
import java.util.Date

data class TaskGetResponse(
    val id: Long,
    val name: String,
    val description: String,
    val priority: TaskPriority,
    val date: Date,
    val completed: Boolean
)


fun Task.toResponse(): TaskGetResponse {
    return TaskGetResponse(
        id = id,
        name = name,
        description = description,
        priority = priority,
        date = date,
        completed = completed
    )
}
