package com.shiftkey.codingchallenge.presentation.ui.screens

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shiftkey.codingchallenge.navigation.NavigationTree
import com.shiftkey.codingchallenge.presentation.ui.MainViewModel
import com.shiftkey.codingchallenge.presentation.ui.screens.details.DetailsScreen
import com.shiftkey.codingchallenge.presentation.ui.screens.shifts.ShiftsScreen


@Composable
fun ApplicationScreen() {

    val navController = rememberNavController()
    val viewModelLocation = hiltViewModel<MainViewModel>()

    NavHost(navController = navController, startDestination = NavigationTree.Shifts.name) {

        composable(NavigationTree.Shifts.name) {
            ShiftsScreen(viewModel = viewModelLocation, navController = navController)
        }
        composable("${NavigationTree.Details.name}/{selected_shift}") { backStackEntry ->
            DetailsScreen(backStackEntry.arguments?.getString("selected_shift").orEmpty(),
                viewModel = viewModelLocation)
        }
    }
}

@Composable
@ReadOnlyComposable
fun textResource(@StringRes id: Int): CharSequence =
    LocalContext.current.resources.getText(id)
