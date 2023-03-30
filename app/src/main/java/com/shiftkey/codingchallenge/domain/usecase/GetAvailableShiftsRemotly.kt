package com.shiftkey.codingchallenge.domain.usecase

import com.shiftkey.codingchallenge.data.model.ShiftItem
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository

class GetAvailableShiftsRemotely(
    private val repository: ShiftsRepository
) {
    suspend fun invoke(type: String?,
                       start: String?,
                       end: String?,
                       address: String,
                       radius: Long?): ShiftItem {
        return repository.getShifts(type,
            start,
            end,
            address,
            radius)
    }
}