package com.example.todoapi.user.request

import com.example.todoapi.user.entity.User

data class UserCreateRequest(
    val username: String,
    val firstName: String,
    val lastName: String,
    val password: String
)

fun UserCreateRequest.toEntity()  = User(
    id = 0,
    username = username,
    firstName = firstName,
    lastName = lastName,
    password = password,
)
