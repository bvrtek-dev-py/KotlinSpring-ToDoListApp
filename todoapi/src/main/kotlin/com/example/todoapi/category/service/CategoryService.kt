package com.example.todoapi.category.service

import com.example.todoapi.category.entity.Category
import com.example.todoapi.category.repository.CategoryRepository
import com.example.todoapi.category.request.CategoryRequest
import com.example.todoapi.common.exceptions.ObjectDoesNotExist
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService @Autowired constructor(private val categoryRepository: CategoryRepository) {
    fun getAll(): MutableIterable<Category> = categoryRepository.findAll()

    fun getById(id: Long): Category = categoryRepository.findById(id).orElseThrow { ObjectDoesNotExist() }

    fun create(data: CategoryRequest): Category = categoryRepository.save(Category(id = 0, name = data.name))

    fun update(id: Long, data: CategoryRequest): Category {
        val category = getById(id)
        val updatedCategory = Category(id = category.id, name = data.name)
        return categoryRepository.save(updatedCategory)
    }

    fun delete(id: Long): Unit {
        val category = getById(id)
        categoryRepository.delete(category)
    }
}