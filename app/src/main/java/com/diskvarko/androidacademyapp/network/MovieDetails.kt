package com.diskvarko.androidacademyapp.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetails(
        @SerialName("backdrop_path")
        val backdropPath: String,

        val genres: List<Genre>,
        val id: Int,

        val overview: String,

        @SerialName("poster_path")
        val posterPath: String,

        val runtime: Int,

        val title: String,

        @SerialName("vote_average")
        val voteAverage: Float,

        @SerialName("vote_count")
        val voteCount: Int
)
