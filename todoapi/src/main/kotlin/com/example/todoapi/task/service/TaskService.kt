package com.example.todoapi.task.service

import com.example.todoapi.common.exceptions.ObjectDoesNotExist
import com.example.todoapi.task.entity.Task
import com.example.todoapi.task.repository.TaskRepository
import com.example.todoapi.task.request.TaskCreateRequest
import com.example.todoapi.task.request.TaskUpdateRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService @Autowired constructor(private val taskRepository: TaskRepository) {
    fun getAll(): Iterable<Task> = taskRepository.findAll()

    fun getById(id: Long): Task = taskRepository.findById(id).orElseThrow { ObjectDoesNotExist() }

    fun create(data: TaskCreateRequest): Task =
        taskRepository.save(Task(0, data.name, data.description, data.priority, data.date))

    fun update(id: Long, data: TaskUpdateRequest): Task {
        val task = getById(id)

        val updatedTask = Task(
            id = task.id,
            name = data.name,
            description = data.description,
            priority = data.priority,
            date = data.date,
            completed = data.completed
        )

        return taskRepository.save(updatedTask)
    }

    fun delete(id: Long): Unit {
        val task = getById(id)
        taskRepository.delete(task)
    }
}