package com.diskvarko.androidacademyapp

import  android.os.Bundle
import android.text.TextUtils.replace
import androidx.appcompat.app.AppCompatActivity
import com.diskvarko.androidacademyapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , FragmentClick{

    private lateinit var someFragment: FragmentMoviesList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState==null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, FragmentMoviesList())
                    .commit()

        }
    }

     override fun showFilmDetails() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_container, FragmentMoviesDetails())
            commit()
        }

    }
    override fun toList(){
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




