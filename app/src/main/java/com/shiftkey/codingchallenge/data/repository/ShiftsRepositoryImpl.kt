package com.shiftkey.codingchallenge.data.repository

import com.shiftkey.codingchallenge.data.model.ShiftItem
import com.shiftkey.codingchallenge.data.rest.AvailableShiftsApi
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository


class ShiftsRepositoryImpl(private val api: AvailableShiftsApi):
    ShiftsRepository {
    override suspend fun getShifts(type: String?,
                                            start: String?,
                                            end: String?,
                                            address: String,
                                            radius: Long?): ShiftItem =
        api.getShifts(type, start, end,address, radius)
}