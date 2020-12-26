package com.diskvarko.androidacademyapp

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diskvarko.androidacademyapp.data.Movie

class MoviesListFragment() : Fragment(), MoviesAdapter.OnMovieClickListener {

    private var movies: List<Movie> = listOf()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movies_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movies = MainActivity.movies

        val recyclerView = view.findViewById<RecyclerView>(R.id.movie_list_recycler_view)

        if (activity!!.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        }

        recyclerView.adapter = MoviesAdapter(this)
        (recyclerView.adapter as MoviesAdapter).setMovies(movies)

    }

    companion object {
        const val TAG = "movieList"
        fun newInstance(): MoviesListFragment = MoviesListFragment()
    }

    override fun onMovieClick(movie: Movie) {
        requireActivity().supportFragmentManager
                .beginTransaction()
                .add(
                        R.id.main_container,
                        MoviesDetailsFragment.newInstance(movie.id),
                        MoviesDetailsFragment.TAG
                )
                .addToBackStack(MoviesDetailsFragment.TAG)
                .commit()
    }
}

