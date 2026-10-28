package com.example.userpostapp.di.repository

import com.example.userpostapp.data.repository.UserPostRepositoryImpl
import com.example.userpostapp.domain.repository.UserPostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun getUserPostRepository(userPostRepositoryImpl: UserPostRepositoryImpl): UserPostRepository
}