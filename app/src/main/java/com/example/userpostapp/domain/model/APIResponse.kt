package com.example.userpostapp.domain.model

sealed class APIResponse<T> {
    data class SUCCESS<T>(val data: T): APIResponse<T>()
    data class ERROR(val error: String): APIResponse<Nothing>()
}