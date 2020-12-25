package com.diskvarko.androidacademyapp.data

import com.diskvarko.androidacademyapp.data.Actor
import com.diskvarko.androidacademyapp.data.Genre

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster: String,
    val backdrop: String,
    val ratings: Float,
    val numberOfRatings: Int,
    val minimumAge: Int,
    val runtime: Int,
    val genres: List<Genre>,
    val actors: List<Actor>
)