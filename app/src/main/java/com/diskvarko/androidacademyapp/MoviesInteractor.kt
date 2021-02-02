package com.diskvarko.androidacademyapp

import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.data.getMoviesList
import com.diskvarko.androidacademyapp.room.DaoMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MoviesInteractor(private val moviesDao: DaoMovie) {

    suspend fun getAllMovies(): List<Movie> = withContext(Dispatchers.IO) {
        moviesDao.getAll()
    }

    suspend fun addMovies(movies: List<Movie>) = withContext(Dispatchers.IO) {
        moviesDao.addAll(movies)
    }

    suspend fun getMovieById(id: Int): Movie = withContext(Dispatchers.IO) {
        moviesDao.getMovieById(id)
    }


}