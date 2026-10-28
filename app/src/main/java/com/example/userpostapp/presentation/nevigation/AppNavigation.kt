package com.example.userpostapp.presentation.nevigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.userpostapp.presentation.screen.UserPostScreen
import com.example.userpostapp.presentation.viewmodel.UserPostViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, ScreenRoute.HOME) {
        composable<ScreenRoute.HOME> {
            val userPostViewModel = hiltViewModel<UserPostViewModel>()
            val userPostUIState by userPostViewModel.userPostUIState.collectAsStateWithLifecycle()
            UserPostScreen(userPostUIState)
        }
    }
}