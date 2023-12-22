package com.example.todoapi.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "app_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val username: String,
    val firstName: String,
    val lastName: String,
    val password: String
)
