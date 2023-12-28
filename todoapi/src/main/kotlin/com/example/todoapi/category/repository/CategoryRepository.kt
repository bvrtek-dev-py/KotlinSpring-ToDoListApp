package com.example.todoapi.category.repository

import com.example.todoapi.category.entity.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long> {}