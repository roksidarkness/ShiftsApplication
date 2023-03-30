package com.shiftkey.codingchallenge.domain.repository

import com.shiftkey.codingchallenge.data.model.ShiftItem

interface ShiftsRepository {

    suspend fun getShifts(type: String?,
                          start: String?,
                          end: String?,
                          address: String,
                          radius: Long?): ShiftItem

}