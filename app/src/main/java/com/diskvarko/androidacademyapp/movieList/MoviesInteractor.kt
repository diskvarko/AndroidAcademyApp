package com.diskvarko.androidacademyapp.movieList

import android.content.Context
import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.data.loadMovies

class MoviesInteractor(private val context: Context) {

    suspend fun getMoviesList(): List<Movie> {
        return loadMovies(context)
    }
}