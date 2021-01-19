package com.diskvarko.androidacademyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diskvarko.androidacademyapp.data.Movie


class MainActivity : AppCompatActivity(), MoviesDetailsFragment.MovieDetailsClickListener {

    private lateinit var rootFragment: MoviesListFragment
    private lateinit var detailsFragment: MoviesDetailsFragment

    companion object {
        var movies: List<Movie> = listOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            rootFragment = MoviesListFragment.newInstance()
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




