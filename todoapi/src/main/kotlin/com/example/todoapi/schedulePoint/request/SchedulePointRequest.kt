package com.example.todoapi.schedulePoint.request

import java.util.Date

data class SchedulePointRequest(
    val startDatetime: Date,
    val endDatetime: Date
)
