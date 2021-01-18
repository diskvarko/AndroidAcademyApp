package com.diskvarko.androidacademyapp.movieList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diskvarko.androidacademyapp.data.Movie
import kotlinx.coroutines.launch

class MoviesViewModel(private val interactor: MoviesInteractor) : ViewModel() {

    val _movieLiveData: MutableLiveData<List<Movie>> = MutableLiveData(emptyList())
    val moviesList: LiveData<List<Movie>> get() = _movieLiveData

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            val movies = interactor.getMoviesList()
            _movieLiveData.postValue(interactor.getMoviesList())
        }
    }
}
