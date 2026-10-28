package com.example.userpostapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.userpostapp.presentation.nevigation.AppNavigation
import com.example.userpostapp.presentation.theme.ui.UserPostAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserPostAppTheme {
                App {
                    Scaffold(modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text("User Post")
                                },
                                navigationIcon = {
                                    IconButton(onClick = {}) {
                                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", tint = Color.Magenta)
                                    }
                                },
                                actions = {
                                    IconButton(onClick = {}) {
                                        Icon(imageVector = Icons.Default.Add, contentDescription = "", tint = Color.Magenta)
                                    }
                                },
                                colors = TopAppBarColors(
                                    containerColor = Color.Cyan,
                                    titleContentColor = Color.Magenta,
                                    scrolledContainerColor = Color.Transparent,
                                    navigationIconContentColor = Color.Transparent,
                                    actionIconContentColor = Color.Transparent
                                )
                            )
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            AppNavigation()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun App(content: @Composable () -> Unit) {
    content()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserPostAppTheme {
        App {}
    }
}