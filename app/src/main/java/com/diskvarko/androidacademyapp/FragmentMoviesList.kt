package com.diskvarko.androidacademyapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {
    private var fragmentClick: FragmentClick? = null
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        view?.findViewById<TextView>(R.id.name_film)?.setOnClickListener {
            fragmentClick?.showFilmDetails()
        }
        view?.findViewById<ImageView>(R.id.avengers_poster)?.setOnClickListener {
            fragmentClick?.showFilmDetails()
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentClick) {
            fragmentClick = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentClick = null
    }

    companion object {
        fun newInstance() = FragmentMoviesList()
        const val MOVIE_LIST_TAG = "movieList"
    }
}
