package com.venkat.android_moviedb_app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieResponseDto(
    val results: List<MovieDto>
)

data class MovieDto(
    val id: Int,
    val title: String,
    @SerializedName("poster_path") val posterPath: String
)