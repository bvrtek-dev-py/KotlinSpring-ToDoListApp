package com.example.todoapi.schedulePoint.repository

import com.example.todoapi.schedulePoint.entity.SchedulePoint
import org.springframework.data.repository.CrudRepository

interface SchedulePointRepository : CrudRepository<SchedulePoint, Long> {}