package com.example.todoapi.category.response

import com.example.todoapi.category.entity.Category

data class CategoryResponse(
    val id: Long,
    val name: String,
)


fun Category.toResponse() = CategoryResponse(
    id = id,
    name = name
)
