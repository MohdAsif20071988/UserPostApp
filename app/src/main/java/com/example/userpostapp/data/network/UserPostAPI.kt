package com.example.userpostapp.data.network

import com.example.userpostapp.common.USER_POST_END_POINT
import com.example.userpostapp.data.model.UserPostDTO
import retrofit2.Response
import retrofit2.http.GET

interface UserPostAPI {

    @GET(USER_POST_END_POINT)
    suspend fun getUserPost(): Response<List<UserPostDTO>>
}