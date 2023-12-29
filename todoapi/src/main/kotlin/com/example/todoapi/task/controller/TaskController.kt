package com.example.todoapi.task.controller

import com.example.todoapi.task.request.TaskCreateRequest
import com.example.todoapi.task.request.TaskUpdateRequest
import com.example.todoapi.task.response.TaskGetResponse
import com.example.todoapi.task.response.toResponse
import com.example.todoapi.task.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tasks")
class TaskController @Autowired constructor(private val taskService: TaskService) {
    @PostMapping
    fun createTask(@RequestBody request: TaskCreateRequest): ResponseEntity<TaskGetResponse> {
        return ResponseEntity(
            taskService.create(request).toResponse(), HttpStatus.CREATED
        )
    }

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<TaskGetResponse>> {
        return ResponseEntity(
            taskService.getAll().map { it.toResponse() }, HttpStatus.OK
        )
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Long): ResponseEntity<TaskGetResponse> {
        return ResponseEntity(
            taskService.getById(id).toResponse(), HttpStatus.OK
        )
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody request: TaskUpdateRequest): ResponseEntity<TaskGetResponse> {
        return ResponseEntity(
            taskService.update(id, request).toResponse(), HttpStatus.OK
        )
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity(
            taskService.delete(id), HttpStatus.NO_CONTENT
        )
    }
}