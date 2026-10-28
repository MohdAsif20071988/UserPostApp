package com.example.userpostapp.di.network

import com.example.userpostapp.common.BASE_URL
import com.example.userpostapp.data.network.UserPostAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun getBaseUrl(): String = BASE_URL

    @Provides
    @Singleton
    fun getRetrofit(baseUrl: String): Retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
        GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun getUserPostAPI(retrofit: Retrofit): UserPostAPI = retrofit.create<UserPostAPI>(UserPostAPI::class.java)
}