package com.shiftkey.codingchallenge.presentation.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.shiftkey.codingchallenge.navigation.NavigationTree

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = Unit, block = {
        navController.navigate(NavigationTree.Shifts.name)
    })
}