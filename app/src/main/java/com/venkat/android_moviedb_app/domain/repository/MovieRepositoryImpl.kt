package com.venkat.android_moviedb_app.domain.repository

import com.venkat.android_moviedb_app.data.mapper.toDomain
import com.venkat.android_moviedb_app.data.remote.api.MovieApi
import com.venkat.android_moviedb_app.domain.model.Movie

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getPopularMovies(): List<Movie> {
        return api.getPopularMovies("b752ba81db142b83cbb48a98ad203996").results.map { it.toDomain() }
    }
}
