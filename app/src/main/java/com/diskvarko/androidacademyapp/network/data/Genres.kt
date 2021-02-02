package com.diskvarko.androidacademyapp.network.data


import kotlinx.serialization.Serializable

@Serializable
data class Genres(
    val genres: List<Genre>
)

@Serializable
data class Genre(

    val id: Int,
    val name: String
)