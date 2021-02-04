package com.diskvarko.androidacademyapp.movieList

import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.data.getMoviesList


class MoviesInteractor() {

    suspend fun getMovies(): List<Movie> {
        return getMoviesList()
    }
}