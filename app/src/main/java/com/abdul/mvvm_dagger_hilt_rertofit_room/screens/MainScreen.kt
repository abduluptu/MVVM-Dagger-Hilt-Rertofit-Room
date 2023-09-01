package com.abdul.mvvm_dagger_hilt_rertofit_room.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(isLoading: Boolean, onLoadingComplete: () -> Unit) {
    // You can use the isLoading state to determine when to show a loading indicator
    if (isLoading) {
        LoadingScreen(onLoadingComplete)
    } else {
        // Your main content when loading is complete
        Text("Welcome to My App!")
    }
}