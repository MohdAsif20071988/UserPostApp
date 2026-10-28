package com.example.userpostapp.domain.usecase

import com.example.userpostapp.domain.model.APIResponse
import com.example.userpostapp.domain.model.UserPost
import com.example.userpostapp.domain.repository.UserPostRepository
import javax.inject.Inject

class GetUserPostUseCase @Inject constructor(val userPostRepository: UserPostRepository) {
    suspend operator fun invoke(): APIResponse<List<UserPost>> {
        return userPostRepository.getUserPost()
    }
}