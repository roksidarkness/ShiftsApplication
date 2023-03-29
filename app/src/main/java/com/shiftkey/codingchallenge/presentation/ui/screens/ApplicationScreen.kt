package com.shiftkey.codingchallenge.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shiftkey.codingchallenge.navigation.NavigationTree
import com.shiftkey.codingchallenge.presentation.ui.MainViewModel
import com.shiftkey.codingchallenge.presentation.ui.screens.details.DetailsScreen
import com.shiftkey.codingchallenge.presentation.ui.screens.shifts.ShiftsScreen
import com.shiftkey.codingchallenge.presentation.ui.screens.splash.SplashScreen

@Composable
fun ApplicationScreen() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTree.Splash.name) {

        composable(NavigationTree.Splash.name) { SplashScreen(navController) }
        composable(NavigationTree.Shifts.name) {
            val viewModel = remember { MainViewModel() }
            ShiftsScreen(locationViewModel = viewModel, navController = navController)
        }
        composable("${NavigationTree.Details.name}/{selected_shift}") { backStackEntry ->
            DetailsScreen(backStackEntry.arguments?.getString("selected_shift").orEmpty())
        }
    }
}