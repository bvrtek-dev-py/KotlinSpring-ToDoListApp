package com.example.todoapi.task.entity

import com.example.todoapi.task.enums.TaskPriority
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.Date

@Entity
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val description: String,
    val priority: TaskPriority,
    val date: Date,
    val completed: Boolean = false,
)
