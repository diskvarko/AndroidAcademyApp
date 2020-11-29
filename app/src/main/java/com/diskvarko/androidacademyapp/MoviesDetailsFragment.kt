package com.diskvarko.androidacademyapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MoviesDetailsFragment : Fragment() {

    private var fragmentClick: FragmentClick? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movies_details, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.back_button)?.setOnClickListener {
              activity?.onBackPressed()
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
        fun newInstance(): MoviesDetailsFragment {
            return MoviesDetailsFragment()
        }
    }
}



