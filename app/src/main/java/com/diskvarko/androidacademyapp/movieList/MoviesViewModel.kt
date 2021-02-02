package com.diskvarko.androidacademyapp.movieList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diskvarko.androidacademyapp.MoviesInteractor
import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.data.getMoviesList
import kotlinx.coroutines.launch

class MoviesViewModel(private val interactor: MoviesInteractor) : ViewModel() {

    private var _movieListLiveData: MutableLiveData<List<Movie>> = MutableLiveData(emptyList())
    val movieListLiveData: LiveData<List<Movie>>
        get() = _movieListLiveData

    private var _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loadingLiveData: LiveData<Boolean>
        get() = _loadingLiveData

    init {
        viewModelScope.launch {
            _movieListLiveData.value = interactor.getAllMovies()
        }
    }

    fun getMovieList() {
        viewModelScope.launch {
            _loadingLiveData.value = true
            val loadedMovies = getMoviesList()
            _movieListLiveData.value = loadedMovies
            _loadingLiveData.value = false
            interactor.addMovies(loadedMovies)
        }
    }
}
