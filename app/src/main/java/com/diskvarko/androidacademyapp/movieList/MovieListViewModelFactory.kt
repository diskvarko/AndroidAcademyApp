package com.diskvarko.androidacademyapp.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieListViewModelFactory(private val interactor: MoviesInteractor) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesViewModel::class.java -> MoviesViewModel(interactor)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}