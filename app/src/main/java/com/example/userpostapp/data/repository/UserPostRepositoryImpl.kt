package com.example.userpostapp.data.repository

import com.example.userpostapp.data.model.toDomain
import com.example.userpostapp.data.network.UserPostAPI
import com.example.userpostapp.domain.model.APIResponse
import com.example.userpostapp.domain.model.UserPost
import com.example.userpostapp.domain.repository.UserPostRepository
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class UserPostRepositoryImpl @Inject constructor(val userPostAPI: UserPostAPI): UserPostRepository {
    override suspend fun getUserPost(): APIResponse<List<UserPost>> {
        return try {
            val response = userPostAPI.getUserPost()

            if(response.isSuccessful) {
                response.body()?.let {
                    APIResponse.SUCCESS(it.map { userPostDTO -> userPostDTO.toDomain()})
                } ?:  APIResponse.ERROR("Something Went wrong!")

            } else {
                APIResponse.ERROR("Something Went wrong!")
            }
        } catch(cancellationException: CancellationException) {
            throw cancellationException
        } catch(exception: Exception) {
            APIResponse.ERROR(exception.message.toString())
        }
    }
}