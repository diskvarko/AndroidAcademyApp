package com.diskvarko.androidacademyapp

import android.widget.ImageView
import android.widget.RatingBar

data class Movie(
    val name: String,
    val poster:ImageView,
    val ratingBar: RatingBar,
    val ratingAge: String,
    val genre: String,
    val review: Int,
    val isLiked: Boolean,
    val duration: Int) {
    fun movies() {}
}
