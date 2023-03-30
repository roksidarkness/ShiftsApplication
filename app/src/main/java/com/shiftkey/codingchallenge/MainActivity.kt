package com.shiftkey.codingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shiftkey.codingchallenge.presentation.ui.screens.ApplicationScreen
import com.shiftkey.codingchallenge.presentation.ui.screens.textResource
import com.shiftkey.codingchallenge.presentation.ui.theme.AppTheme
import com.shiftkey.codingchallenge.presentation.ui.theme.ShiftsApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShiftsApplicationTheme {
                Scaffold(
                    backgroundColor = AppTheme.colors.backgroundColor,
                    topBar = {
                        MainAppBar()
                    }
                ) {
                    val systemUiController = rememberSystemUiController()
                    val primaryBackground = AppTheme.colors.secondaryBackgroundColor
                    SideEffect {
                        systemUiController.setSystemBarsColor(
                            color = primaryBackground,
                            darkIcons = true
                        )
                    }
                    ApplicationScreen()
                }
            }
        }
    }
}

@Composable
private fun MainAppBar() {
    TopAppBar(
        title = { Text(textResource(id = R.string.app_name).toString(),
            color = AppTheme.colors.headerTextColor) },
        backgroundColor = AppTheme.colors.secondaryBackgroundColor)
}
