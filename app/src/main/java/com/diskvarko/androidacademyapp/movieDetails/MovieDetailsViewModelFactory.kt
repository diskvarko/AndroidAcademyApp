package com.diskvarko.androidacademyapp.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diskvarko.androidacademyapp.MoviesInteractor

class MovieDetailsViewModelFactory(private val interactor: MoviesInteractor) :
        ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MovieDetailsViewModel::class.java -> MovieDetailsViewModel(interactor)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}