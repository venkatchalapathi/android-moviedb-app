package com.venkat.android_moviedb_app.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel = hiltViewModel()) {
    val movies = viewModel.movies
    LazyColumn {
        items(movies.size) { movie ->
            Text(movies[movie].title, style = MaterialTheme.typography.h6)
        }
    }
}
