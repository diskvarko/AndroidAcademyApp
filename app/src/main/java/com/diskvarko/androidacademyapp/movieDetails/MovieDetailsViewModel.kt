package com.diskvarko.androidacademyapp.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diskvarko.androidacademyapp.MoviesInteractor
import com.diskvarko.androidacademyapp.data.Movie
import kotlinx.coroutines.launch

class MovieDetailsViewModel (private val interactor: MoviesInteractor) : ViewModel() {

    private var _movieLiveData: MutableLiveData<Movie> = MutableLiveData<Movie>()
    val movieLiveData: LiveData<Movie> get() = _movieLiveData

    private var _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    fun getMovie(movieId: Int) {
        viewModelScope.launch {
            _loadingLiveData.value = true
            _movieLiveData.value = interactor.getMovieById(movieId)
            _loadingLiveData.value = false
        }
    }

}