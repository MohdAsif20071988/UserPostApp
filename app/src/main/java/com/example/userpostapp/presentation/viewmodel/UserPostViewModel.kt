package com.example.userpostapp.presentation.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userpostapp.domain.model.APIResponse
import com.example.userpostapp.domain.usecase.GetUserPostUseCase
import com.example.userpostapp.presentation.model.UserPostUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.reflect.Modifier.PRIVATE
import javax.inject.Inject

@HiltViewModel
class UserPostViewModel @Inject constructor(val getUserPostUseCase: GetUserPostUseCase): ViewModel() {
    private val _userPostUIState = MutableStateFlow<UserPostUIState>(UserPostUIState.LOADING)
    val userPostUIState: StateFlow<UserPostUIState>
        get() = _userPostUIState

    init {
        getUserPost()
    }

    @VisibleForTesting(otherwise = PRIVATE)
    internal fun getUserPost() {
        viewModelScope.launch(Dispatchers.IO) {
            when(val userPostResponse = getUserPostUseCase()) {
                is APIResponse.SUCCESS -> _userPostUIState.update { UserPostUIState.SUCCESS(userPostResponse.data) }
                is APIResponse.ERROR -> _userPostUIState.update { UserPostUIState.ERROR(userPostResponse.error) }

            }
        }
    }
}