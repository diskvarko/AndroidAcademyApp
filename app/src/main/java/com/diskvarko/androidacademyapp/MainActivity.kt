package com.diskvarko.androidacademyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diskvarko.androidacademyapp.FragmentMoviesList.Companion.MOVIE_LIST_TAG


class MainActivity : AppCompatActivity(), FragmentClick {

    private var someFragment: FragmentMoviesList? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            someFragment = FragmentMoviesList.newInstance()
            someFragment?.apply {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, this, MOVIE_LIST_TAG)
                        .commit()
            }

        } else {
            someFragment =
                    supportFragmentManager.findFragmentByTag(MOVIE_LIST_TAG) as? FragmentMoviesList
        }
    }

    override fun showFilmDetails() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_container, FragmentMoviesDetails())
            commit()
        }

    }

    override fun toList() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_container, FragmentMoviesList())
            commit()

        }
    }
}

interface FragmentClick {
    fun showFilmDetails()
    fun toList()
}




