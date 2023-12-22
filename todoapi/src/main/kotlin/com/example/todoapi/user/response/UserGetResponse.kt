package com.example.todoapi.user.response

import com.example.todoapi.user.entity.User

data class UserGetResponse(
    val id: Long,
    val username: String,
    val firstName: String,
    val lastName: String,
)


fun User.toResponse() = UserGetResponse(
    id = id,
    username = username,
    firstName = firstName,
    lastName = lastName
)

