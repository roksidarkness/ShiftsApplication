package com.shiftkey.codingchallenge.data.rest

import com.shiftkey.codingchallenge.data.model.ShiftItem
import retrofit2.http.*

interface AvailableShiftsApi {

    @GET("/api/v2/available_shifts")
    suspend fun getShifts(
        @Query("type") type: String?,
        @Query("start") start: String?,
        @Query("end") end: String?,
        @Query("address") address: String,
        @Query("radius") radius: Long?
    ): ShiftItem
}