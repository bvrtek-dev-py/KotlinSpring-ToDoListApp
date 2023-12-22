package com.example.todoapi.user.controller

import com.example.todoapi.user.request.UserCreateRequest
import com.example.todoapi.user.request.UserUpdateRequest
import com.example.todoapi.user.response.UserGetResponse
import com.example.todoapi.user.response.toResponse
import com.example.todoapi.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(private val userService: UserService){
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserGetResponse>> {
        val users = userService.getAll()
        return ResponseEntity(users.map { it.toResponse() }, HttpStatus.OK)
    }
    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long): ResponseEntity<UserGetResponse> {
        return ResponseEntity(userService.getById(userId).toResponse(), HttpStatus.OK)
    }
    @PostMapping
    fun createUser(@RequestBody user: UserCreateRequest): ResponseEntity<UserGetResponse> {
        return ResponseEntity(userService.create(user).toResponse(), HttpStatus.CREATED)
    }
    @PutMapping("/{userId}")
    fun updateUser(@PathVariable userId: Long, @RequestBody user: UserUpdateRequest): ResponseEntity<UserGetResponse>  {
        return ResponseEntity(userService.update(userId, user).toResponse(), HttpStatus.CREATED)
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Long): ResponseEntity<Unit>  {
        return ResponseEntity(userService.delete(userId), HttpStatus.NO_CONTENT)
    }
}