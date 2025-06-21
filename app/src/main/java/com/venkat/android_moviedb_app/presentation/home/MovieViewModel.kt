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

    var isLoading by mutableStateOf(false)
        private set

    var page = 1
    var endReached = false

    init {
        loadMovies()
    }

    fun loadMovies() {
        if (isLoading || endReached) return

        viewModelScope.launch {
            isLoading = true
            val result = getPopularMoviesUseCase(page)

            result.onSuccess { response ->
                val newMovies = response
                if (newMovies.isEmpty()) {
                    endReached = true
                } else {
                    movies = movies + newMovies
                    page++
                }
            }.onFailure {
                // Handle error
            }
            isLoading = false
        }
    }
}
