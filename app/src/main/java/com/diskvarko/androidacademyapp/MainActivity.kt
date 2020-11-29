package com.diskvarko.androidacademyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diskvarko.androidacademyapp.MoviesListFragment.Companion.MOVIE_LIST_TAG
import com.diskvarko.androidacademyapp.MoviesListFragment.Companion.newInstance


class MainActivity : AppCompatActivity(), FragmentClick {

    private var someFragment: MoviesListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, MoviesListFragment.newInstance())
                        .commit()


        } else {
            someFragment =
                    supportFragmentManager.findFragmentByTag(MOVIE_LIST_TAG) as? MoviesListFragment
        }
    }

    override fun showFilmDetails() {
        supportFragmentManager.beginTransaction()
                .add(R.id.main_container, MoviesDetailsFragment.newInstance())
                .addToBackStack(null)
                .commit()

    }
}




