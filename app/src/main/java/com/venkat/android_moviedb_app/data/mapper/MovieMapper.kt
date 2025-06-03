package com.venkat.android_moviedb_app.data.mapper

import com.venkat.android_moviedb_app.data.remote.dto.MovieDto
import com.venkat.android_moviedb_app.domain.model.Movie

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        posterUrl = "https://image.tmdb.org/t/p/w200$posterPath"
    )
}
