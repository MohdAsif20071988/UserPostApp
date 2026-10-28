package com.example.userpostapp.presentation.viewmodel

import app.cash.turbine.test
import com.example.userpostapp.MainTestDispatcher
import com.example.userpostapp.domain.model.APIResponse
import com.example.userpostapp.domain.model.UserPost
import com.example.userpostapp.domain.usecase.GetUserPostUseCase
import com.example.userpostapp.presentation.model.UserPostUIState
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserPostViewModelTest {

    @get:Rule val testDispatcher = MainTestDispatcher()

    private val getUserPostUseCase = mockk<GetUserPostUseCase>()

    lateinit var userPostViewModel: UserPostViewModel


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `verify getUserPostUseCase call`() = runTest {
        val userPost = listOf(UserPost("Post Body", 1, "Post Title", 101))
        val apiSuccessResponse = APIResponse.SUCCESS(userPost)

        coEvery { getUserPostUseCase() } coAnswers {
            apiSuccessResponse
        }

        userPostViewModel = UserPostViewModel(getUserPostUseCase)
        advanceUntilIdle()
        coVerify(exactly = 1) {
            getUserPostUseCase()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test getUserPost success`() = runTest {
        val userPost = listOf(UserPost("Post Body", 1, "Post Title", 101))
        val apiSuccessResponse = APIResponse.SUCCESS(userPost)

        coEvery { getUserPostUseCase() } coAnswers {
            delay(100)
            apiSuccessResponse
        }

        userPostViewModel = UserPostViewModel(getUserPostUseCase)
        userPostViewModel.userPostUIState.test {
            assertEquals(awaitItem(), UserPostUIState.LOADING)
            advanceUntilIdle()
            assertEquals(awaitItem(), UserPostUIState.SUCCESS(userPost))
            cancelAndIgnoreRemainingEvents()
        }

        coVerify(exactly = 1) {
            getUserPostUseCase()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test getUserPost failure`() = runTest {
        val errorMessage = "Something went wrong!"
        val apiErrorResponse = APIResponse.ERROR(error = errorMessage)

        coEvery { getUserPostUseCase() } coAnswers {
            delay(100)
            apiErrorResponse
        }
        userPostViewModel = UserPostViewModel(getUserPostUseCase)
        userPostViewModel.userPostUIState.test {
            assertEquals(awaitItem(), UserPostUIState.LOADING)
            advanceUntilIdle()
            assertEquals(awaitItem(), UserPostUIState.ERROR(errorMessage))

            cancelAndIgnoreRemainingEvents()
        }

        coVerify(exactly = 1) {
            getUserPostUseCase()
        }
    }

    @After
    fun clear() {
        clearAllMocks()
    }
}