package com.example.todoapi.user.service

import com.example.todoapi.common.exceptions.ObjectDoesNotExist
import com.example.todoapi.user.entity.User
import com.example.todoapi.user.repository.UserRepository
import com.example.todoapi.user.request.UserCreateRequest
import com.example.todoapi.user.request.UserUpdateRequest
import com.example.todoapi.user.request.toEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {
    fun create(data: UserCreateRequest): User {
        return userRepository.save(data.toEntity())
    }

    fun update(userId: Long, data: UserUpdateRequest): User {
        val user = getById(userId)

        val updatedUser = User(
            id = user.id,
            username = user.username,
            password = user.password,
            firstName = data.firstName,
            lastName = data.lastName
        )

        return userRepository.save(updatedUser)
    }

    fun delete(userId: Long): Unit {
        val user = getById(userId)
        userRepository.delete(user)
    }

    fun getAll(): Iterable<User> = userRepository.findAll()

    fun getById(id: Long): User {
        if (!userRepository.existsById(id)) {
            throw ObjectDoesNotExist()
        }

        return userRepository.findById(id).get()
    }
}