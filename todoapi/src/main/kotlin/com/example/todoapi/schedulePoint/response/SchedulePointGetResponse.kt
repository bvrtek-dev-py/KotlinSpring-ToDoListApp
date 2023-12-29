package com.example.todoapi.schedulePoint.response

import com.example.todoapi.schedulePoint.entity.SchedulePoint
import java.util.Date

data class SchedulePointGetResponse(
    val id: Long,
    val startDatetime: Date,
    val endDatetime: Date
)


fun SchedulePoint.toResponse(): SchedulePointGetResponse {
    return SchedulePointGetResponse(
        id = id,
        startDatetime = startDatetime,
        endDatetime = endDatetime
    )
}