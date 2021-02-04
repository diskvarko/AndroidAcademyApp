package com.diskvarko.androidacademyapp.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diskvarko.androidacademyapp.movieList.MoviesInteractor
import com.diskvarko.androidacademyapp.data.Movie
import kotlinx.coroutines.launch

class MovieDetailsViewModel (private val interactor: MoviesInteractor) : ViewModel() {

    private var _mutableMovie: MutableLiveData<Movie> = MutableLiveData(
            Movie(
                    id = 0,
                    title = "",
                    overview = "",
                    poster = "",
                    backdrop = "",
                    ratings = 0f,
                    numberOfRatings = 0,
                    minimumAge = 0,
                    runtime = 0,
                    genres = listOf(),
                    actors = listOf()
            )
    )

    val movie: LiveData<Movie> get() = _mutableMovie
    private var _moviesLiveData: MutableLiveData<Int> = MutableLiveData(0)
    val moviesLiveData: LiveData<Int> get() = _moviesLiveData

    fun getMovie() {
        viewModelScope.launch {
            val movieID = moviesLiveData.value
            val movies = interactor.getMoviesList()
            val movie = movies.find { actor -> movieID == actor.id }
            if (movie != null) {
                _mutableMovie.postValue(movie)
            }
        }
    }

    fun setMovie(movieID: Int) {
        viewModelScope.launch {
            _moviesLiveData.postValue(movieID)
        }
    }
}