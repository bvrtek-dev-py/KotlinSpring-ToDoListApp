package com.example.todoapi.schedulePoint.service

import com.example.todoapi.common.exceptions.ObjectDoesNotExist
import com.example.todoapi.schedulePoint.entity.SchedulePoint
import com.example.todoapi.schedulePoint.repository.SchedulePointRepository
import com.example.todoapi.schedulePoint.request.SchedulePointRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SchedulePointService @Autowired constructor(private val schedulePointRepository: SchedulePointRepository) {
    fun getAll(): Iterable<SchedulePoint> = schedulePointRepository.findAll()

    fun getById(id: Long): SchedulePoint = schedulePointRepository.findById(id).orElseThrow { ObjectDoesNotExist() }

    fun create(data: SchedulePointRequest): SchedulePoint = schedulePointRepository.save(SchedulePoint(0, data.startDatetime, data.endDatetime,))

    fun update(id: Long, data: SchedulePointRequest): SchedulePoint {
        val schedulePoint = getById(id)

        val updatedSchedule = SchedulePoint(schedulePoint.id, data.startDatetime, data.endDatetime)

        return schedulePointRepository.save(updatedSchedule)
    }

    fun delete(id: Long): Unit {
        val schedulePoint = getById(id)
        schedulePointRepository.delete(schedulePoint)
    }
}