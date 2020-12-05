package com.diskvarko.androidacademyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val cast = Actor.actors()
        val list = view.findViewById<RecyclerView>(R.id.actor_list)
        list.adapter = ActorsAdapter(cast)
        list.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)

        if (cast.size > 0) {
            list.visibility = android.view.View.VISIBLE
        } else {
            list.visibility = android.view.View.INVISIBLE
        }

    }


//    override fun onDetach() {
//        super.onDetach()
//        fragmentClick = null
//    }

    companion object {
        fun newInstance(): MoviesDetailsFragment {
            return MoviesDetailsFragment()
        }
    }
}



