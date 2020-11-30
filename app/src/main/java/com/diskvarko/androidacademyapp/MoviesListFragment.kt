package com.diskvarko.androidacademyapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class MoviesListFragment : Fragment() {

    private var fragmentClick: FragmentClick? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movies_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.name_film)?.setOnClickListener {
            fragmentClick?.showFilmDetails()
        }
        view.findViewById<ImageView>(R.id.avengers_poster)?.setOnClickListener {
            fragmentClick?.showFilmDetails()
        }
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
        fun newInstance() = MoviesListFragment()
        const val MOVIE_LIST_TAG = "movieList"
    }
}
interface FragmentClick {
    fun showFilmDetails()
}
