package com.example.userpostapp.presentation.model

import com.example.userpostapp.domain.model.UserPost

sealed class UserPostUIState {
    object LOADING: UserPostUIState()
    data class SUCCESS(val userPost: List<UserPost>): UserPostUIState()
    data class ERROR(val error: String): UserPostUIState()
}