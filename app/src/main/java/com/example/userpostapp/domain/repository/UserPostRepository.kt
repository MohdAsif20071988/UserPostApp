package com.example.userpostapp.domain.repository

import com.example.userpostapp.domain.model.APIResponse
import com.example.userpostapp.domain.model.UserPost

interface UserPostRepository {
    suspend fun getUserPost(): APIResponse<List<UserPost>>
}