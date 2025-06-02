package com.venkat.android_moviedb_app.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venkat.android_moviedb_app.domain.model.Movie
import com.venkat.android_moviedb_app.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            movies = getPopularMoviesUseCase()
        }
    }
}
