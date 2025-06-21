package com.venkat.android_moviedb_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.Color
import com.venkat.android_moviedb_app.presentation.home.MovieScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            backgroundColor = Color.Red,
                            title = { Text("Movie App", color = Color.White) })
                    },
                    content = { innerPadding ->
                        // Your screen content here
                        Box(modifier = androidx.compose.ui.Modifier.padding(innerPadding)) {
                            MovieScreen()
                        }
                    }
                )
            }
        }
    }
}
