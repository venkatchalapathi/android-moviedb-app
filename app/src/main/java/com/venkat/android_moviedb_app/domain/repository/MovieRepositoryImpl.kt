package com.venkat.android_moviedb_app.domain.repository

import com.venkat.android_moviedb_app.data.mapper.toDomain
import com.venkat.android_moviedb_app.data.remote.api.MovieApi
import com.venkat.android_moviedb_app.domain.model.Movie

class MovieRepositoryImpl(private val api: MovieApi) : MovieRepository {

    override suspend fun getPopularMovies(page:Int): Result<List<Movie>> {

        return try{
            val response = api.getPopularMovies("b752ba81db142b83cbb48a98ad203996", page).results.map { it.toDomain() }
            Result.success(response)
        }catch (e:Exception){
            Result.failure(e)
        }
    }

}