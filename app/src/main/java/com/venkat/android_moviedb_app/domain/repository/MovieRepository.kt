package com.venkat.android_moviedb_app.domain.repository

import com.venkat.android_moviedb_app.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
}
