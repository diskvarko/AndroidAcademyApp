package com.diskvarko.androidacademyapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {
    private var fragmentClick: FragmentClick? = null
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        view?.findViewById<ImageView>(R.id.avengers_poster)?.apply {
            setOnClickListener {
                fragmentClick?.showFilmDetails()

            }
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

}