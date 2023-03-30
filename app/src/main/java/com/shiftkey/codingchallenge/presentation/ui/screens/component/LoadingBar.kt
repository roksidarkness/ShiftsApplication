package com.shiftkey.codingchallenge.presentation.ui.screens.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shiftkey.codingchallenge.presentation.ui.theme.AppTheme

@Composable
fun LoadingBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = AppTheme.colors.primaryColor)
    }
}