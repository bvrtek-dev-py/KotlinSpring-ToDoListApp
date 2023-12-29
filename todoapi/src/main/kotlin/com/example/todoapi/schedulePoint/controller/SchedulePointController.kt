package com.example.todoapi.schedulePoint.controller

import com.example.todoapi.schedulePoint.request.SchedulePointRequest
import com.example.todoapi.schedulePoint.response.SchedulePointGetResponse
import com.example.todoapi.schedulePoint.response.toResponse
import com.example.todoapi.schedulePoint.service.SchedulePointService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/schedule-points")
class SchedulePointController @Autowired constructor(private val schedulePointService: SchedulePointService) {
    @GetMapping
    fun getAll(): ResponseEntity<List<SchedulePointGetResponse>> {
        return ResponseEntity(
            schedulePointService.getAll().map { it.toResponse() }, HttpStatus.OK
        )
    }

    @GetMapping("/{id}")
    fun getSchedule(@PathVariable id: Long): ResponseEntity<SchedulePointGetResponse> {
        return ResponseEntity(
            schedulePointService.getById(id).toResponse(), HttpStatus.OK
        )
    }

    @PostMapping
    fun createSchedule(@RequestBody request: SchedulePointRequest): ResponseEntity<SchedulePointGetResponse> {
        return ResponseEntity(
            schedulePointService.create(request).toResponse(), HttpStatus.CREATED
        )
    }

    @DeleteMapping("/{id}")
    fun deleteSchedule(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity(
            schedulePointService.delete(id), HttpStatus.NO_CONTENT
        )
    }

    @PutMapping("/{id}")
    fun updateSchedule(
        @PathVariable id: Long,
        @RequestBody request: SchedulePointRequest
    ): ResponseEntity<SchedulePointGetResponse> {
        return ResponseEntity(
            schedulePointService.update(id, request).toResponse(), HttpStatus.OK
        )
    }
}