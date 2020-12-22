package com.diskvarko.androidacademyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diskvarko.androidacademyapp.MoviesListFragment.Companion.TAG
import com.diskvarko.androidacademyapp.MoviesListFragment.Companion.newInstance


class MainActivity : AppCompatActivity(),  MoviesDetailsFragment.MovieDetailsClickListener {

    private lateinit var rootFragment: MoviesListFragment
    private lateinit var detailsFragment: MoviesDetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            rootFragment = MoviesListFragment.newInstance(object : MoviesAdapter.OnMovieClickListener {
                override fun onMovieClick(movie: Movie) {
                    supportFragmentManager
                            .beginTransaction()
                            .add(
                                    R.id.main_container,
                                    MoviesDetailsFragment.newInstance(),
                                    MoviesDetailsFragment.TAG
                            )
                            .addToBackStack(MoviesDetailsFragment.TAG)
                            .commit()
                }
            })
            supportFragmentManager
                    .beginTransaction()
                    .add(
                            R.id.main_container,
                            rootFragment,
                            MoviesListFragment.TAG
                    )
                    .commit()
        } else {
            val movieList = supportFragmentManager.findFragmentByTag(MoviesListFragment.TAG)
            rootFragment = movieList as MoviesListFragment

            val movieDetails = supportFragmentManager.findFragmentByTag(MoviesDetailsFragment.TAG)
            if (movieDetails != null) {
                detailsFragment = movieDetails as MoviesDetailsFragment
            }
        }
    }

    override fun onBackButtonClicked() {
        onBackPressed()
    }
}




