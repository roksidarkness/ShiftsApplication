package com.shiftkey.codingchallenge.presentation.ui.screens.shifts

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.shiftkey.codingchallenge.presentation.ui.MainViewModel

@Composable
fun ShiftsScreen(
    locationViewModel: MainViewModel,
    navController: NavController
) {
    Text(text = "Location")
}