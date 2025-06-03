package com.venkat.android_moviedb_app.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.venkat.android_moviedb_app.R
import com.venkat.android_moviedb_app.domain.model.Movie

@Composable
fun MovieScreen(viewModel: MovieViewModel = hiltViewModel()) {
    val movies = viewModel.movies
    LazyColumn {
        items(movies.size) { movie ->
            //Text(movies[movie].title, style = MaterialTheme.typography.h6)
            MovieCard(movies[movie])
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        Row (modifier = Modifier.fillMaxSize()){
            Image(
                contentDescription = movie.title,
                modifier = Modifier
                    .size(100.dp,150.dp),
                painter = rememberAsyncImagePainter(movie.posterUrl))
            Text(
                movie.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.CenterVertically).padding(start = 16.dp)
            )
        }

    }
}
