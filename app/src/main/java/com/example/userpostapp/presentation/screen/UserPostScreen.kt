package com.example.userpostapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.userpostapp.presentation.model.UserPostUIState

@Composable
fun UserPostScreen(userPostUIState: UserPostUIState) {
    when(userPostUIState) {
        is UserPostUIState.LOADING -> {
            Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is UserPostUIState.SUCCESS -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                LazyColumn(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                    items(userPostUIState.userPost, key = {it.id}){
                        Card(elevation = CardDefaults.cardElevation(5.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.Cyan)) {
                            Text(modifier = Modifier.fillMaxWidth().padding(10.dp), text = it.title)
                        }
                        Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
                    }
                }
            }
        }
        is UserPostUIState.ERROR -> {
            Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center) {
                Text(userPostUIState.error)
            }
        }
    }
}