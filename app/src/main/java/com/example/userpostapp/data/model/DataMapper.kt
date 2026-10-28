package com.example.userpostapp.data.model

import com.example.userpostapp.domain.model.UserPost

fun UserPostDTO.toDomain(): UserPost {
    return UserPost(body = this.body, id = this.id, userId = this.userId, title = this.title)
}