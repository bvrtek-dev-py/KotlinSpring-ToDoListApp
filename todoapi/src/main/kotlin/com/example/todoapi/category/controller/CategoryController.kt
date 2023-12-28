package com.example.todoapi.category.controller

import com.example.todoapi.category.request.CategoryRequest
import com.example.todoapi.category.response.CategoryResponse
import com.example.todoapi.category.response.toResponse
import com.example.todoapi.category.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
class CategoryController @Autowired constructor(private val categoryService: CategoryService) {

    @PostMapping
    fun createCategory(@RequestBody category: CategoryRequest): ResponseEntity<CategoryResponse> {
        return ResponseEntity(
            categoryService.create(category).toResponse(), HttpStatus.CREATED
        )
    }

    @GetMapping
    fun getAllCategories(): ResponseEntity<List<CategoryResponse>> {
        return ResponseEntity(
            categoryService.getAll().map { it.toResponse() }, HttpStatus.OK
        )
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): ResponseEntity<CategoryResponse> {
        return ResponseEntity(
            categoryService.getById(id).toResponse(), HttpStatus.OK
        )
    }

    @PutMapping("/{id}")
    fun updateCategory(
        @PathVariable id: Long,
        @RequestBody category: CategoryRequest
    ): ResponseEntity<CategoryResponse> {
        return ResponseEntity(
            categoryService.update(id, category).toResponse(), HttpStatus.OK
        )
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity(
            categoryService.delete(id), HttpStatus.NO_CONTENT
        )
    }
}