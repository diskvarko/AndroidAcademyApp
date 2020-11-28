package com.diskvarko.androidacademyapp

import  android.os.Bundle
import android.text.TextUtils.replace
import androidx.appcompat.app.AppCompatActivity
import com.diskvarko.androidacademyapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    // private lateinit var binding: ActivityMainBinding
     private lateinit var someFragment: FragmentMoviesList
    // val firstFrag = FragmentMoviesList()
    // val secondFrag = FragmentMoviesDetails()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, FragmentMoviesList())
                .commit()


    }


//     fun showFilmDetails() {
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.main_container, FragmentMoviesDetails())
//            commit()
//        }
//
//    }

}
interface FragmentClick {
    fun showFilmDetails()
    fun toFirstFragment()
}




