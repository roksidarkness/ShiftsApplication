package com.shiftkey.codingchallenge.data.model

import com.google.gson.annotations.SerializedName

data class ShiftItem (
    @SerializedName("data") val data : List<DataItem>
)

data class DataItem(
    @SerializedName("date") val date: String,
    @SerializedName("shifts") val shifts: List<Shift>
)

data class Shift(
    @SerializedName("shift_id") val shift_id: String,
    @SerializedName("start_time") val startTime: String,
    @SerializedName("end_time") val endTime: String,
    @SerializedName("normalized_start_date_time") val normalizedStartDateTime: String,
    @SerializedName("normalized_end_date_time") val normalizedEndDateTime: String,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("premium_rate") val premiumRate: Boolean,
    @SerializedName("covid") val covid: Boolean,
    @SerializedName("shift_kind") val shiftKind: String,
    @SerializedName("within_distance") val withinDistance: Long,
    @SerializedName("facility_type") val facilityType: FacilityType,
    @SerializedName("skill") val skill: Skills,
    @SerializedName("localized_specialty") val localizedSpecialty: LocalizedSpecialty
)

data class FacilityType(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("color") val color: String
)

data class Skills(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("color") val color: String
)

data class LocalizedSpecialty(
    @SerializedName("id") val id: Int,
    @SerializedName("specialtyId") val specialty_id: Int,
    @SerializedName("state_id") val stateId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("abbreviation") val abbreviation: String,
    @SerializedName("specialty") val specialty: Specialty
)

data class Specialty(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("color") val color: String,
    @SerializedName("abbreviation") val abbreviation: String
)