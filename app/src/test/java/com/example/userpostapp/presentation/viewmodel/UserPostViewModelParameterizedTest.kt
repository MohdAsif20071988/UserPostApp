/*
package com.example.userpostapp.presentation.viewmodel

import com.example.userpostapp.MainTestDispatcher
import com.example.userpostapp.domain.model.APIResponse
import com.example.userpostapp.domain.model.UserPost
import com.example.userpostapp.domain.usecase.GetUserPostUseCase
import com.example.userpostapp.presentation.model.UserPostUIState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class UserPostViewModelParameterizedTest {

    @get:Rule
    val testDispatcher = MainTestDispatcher()

    private val getUserPostUseCase = mockk<GetUserPostUseCase>()

    lateinit var viewModel: UserPostViewModel

    @Test
    fun `test getUserPost success`() = runTest {
        coEvery { getUserPostUseCase() } coAnswers {
            delay(100),
            data()
        }
    }

    @Test
    fun `test getUserPost success`() = runTest {

    }

    companion object {
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(APIResponse.SUCCESS(listOf(UserPost("body", 1, "title", 101))),
                    UserPostUIState.SUCCESS(listOf(UserPost("body", 1, "title", 101)))),
                arrayOf(APIResponse.ERROR("Error"),
                    UserPostUIState.SUCCESS(listOf(UserPost("body", 1, "title", 101))))
            )
        }
    }



}*/
