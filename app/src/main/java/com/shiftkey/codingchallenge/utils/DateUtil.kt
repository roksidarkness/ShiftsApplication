package com.shiftkey.codingchallenge.utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.shiftkey.codingchallenge.utils.Constant.PATTERN_DATE
import com.shiftkey.codingchallenge.utils.Constant.TAG
import com.shiftkey.codingchallenge.utils.Constant.ZONE
import java.text.SimpleDateFormat
import java.util.*

fun getStartDate(): String{
    val c = Calendar.getInstance(TimeZone.getTimeZone(ZONE))
    val sdfNow = SimpleDateFormat(PATTERN_DATE)
    val resultDateNow = Date(c.timeInMillis)
    Log.d(TAG, sdfNow.format(resultDateNow))
    return sdfNow.format(resultDateNow)
}

fun getEndDate(): String {
    val c = Calendar.getInstance(TimeZone.getTimeZone(ZONE))
    c.add(Calendar.DAY_OF_WEEK, 7)
    val result = c.timeInMillis
    val sdf = SimpleDateFormat(PATTERN_DATE)
    val resultDate = Date(result)
    Log.d(TAG, sdf.format(resultDate))
    return sdf.format(resultDate)
}