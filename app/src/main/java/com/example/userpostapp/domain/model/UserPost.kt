package com.example.userpostapp.domain.model

data class UserPost(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)