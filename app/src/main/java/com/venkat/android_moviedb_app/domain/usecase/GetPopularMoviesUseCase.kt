package com.venkat.android_moviedb_app.domain.usecase

import com.venkat.android_moviedb_app.domain.model.Movie
import com.venkat.android_moviedb_app.domain.repository.MovieRepository

class GetPopularMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> = repository.getPopularMovies()
}
