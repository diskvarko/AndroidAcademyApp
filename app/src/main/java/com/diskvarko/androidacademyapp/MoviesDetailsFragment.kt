package com.diskvarko.androidacademyapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.diskvarko.androidacademyapp.data.Movie

class MoviesDetailsFragment : Fragment() {

    private lateinit var movie: Movie
    private var onBackButtonClickListener: MovieDetailsClickListener? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movies_details, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val poster = view.findViewById<ImageView>(R.id.background)
        val title = view.findViewById<TextView>(R.id.name_film)
        val pgRating = view.findViewById<TextView>(R.id.ratingAge)
        val description = view.findViewById<TextView>(R.id.description_storyline)

        view.findViewById<Button>(R.id.back_button)?.setOnClickListener {
            activity?.onBackPressed()
        }

        val movieId = arguments?.getInt(MOVIE_ID)
        movie = MainActivity.movies.single { it.id == movieId }

        val cast = movie.actors
        val list = view.findViewById<RecyclerView>(R.id.actor_list)
        list.adapter = ActorsAdapter(cast)
        list.layoutManager =
                LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        (list.adapter as ActorsAdapter).updateActors(cast)

        if (cast.isNotEmpty()) {
            list.visibility = android.view.View.VISIBLE
        } else {
            list.visibility = android.view.View.INVISIBLE
        }
        if (movie.actors.isEmpty()) view.findViewById<TextView>(R.id.cast).visibility = View.GONE

        poster.load(movie.backdrop)
        title.text = movie.title
        pgRating.text = "${movie.minimumAge}+"
        description.text = movie.overview

    }

    companion object {

        private const val MOVIE_ID = "movieId"
        const val TAG = "MovieDetailsFragment"

        fun newInstance(movieId: Int): MoviesDetailsFragment {
            val bundle = Bundle()
            bundle.putInt(MOVIE_ID, movieId)
            val fragment = MoviesDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onAttach(context: Context) {
        if (context is MovieDetailsClickListener) {
            onBackButtonClickListener = context
        }
        super.onAttach(context)
    }

    interface MovieDetailsClickListener {
        fun onBackButtonClicked()
    }
}






