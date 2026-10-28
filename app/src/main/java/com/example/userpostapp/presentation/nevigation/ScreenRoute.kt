package com.example.userpostapp.presentation.nevigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenRoute {
    @Serializable
    object HOME: ScreenRoute()
}