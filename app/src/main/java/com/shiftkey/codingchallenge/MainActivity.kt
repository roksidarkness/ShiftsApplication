package com.shiftkey.codingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shiftkey.codingchallenge.presentation.ui.screens.ApplicationScreen
import com.shiftkey.codingchallenge.presentation.ui.theme.AppTheme
import com.shiftkey.codingchallenge.presentation.ui.theme.ShiftsApplicationTheme
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShiftsApplicationTheme {
                Scaffold(
                    backgroundColor = Color.Transparent
                ) {
                    val systemUiController = rememberSystemUiController()

                    // Set status bar color
                    val primaryBackground = AppTheme.colors.backgroundColor
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