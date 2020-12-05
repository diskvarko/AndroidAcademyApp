package com.diskvarko.androidacademyapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoviesListFragment(val clickListener: MoviesAdapter.OnMovieClickListener) : Fragment() {

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
        val movieListRecyclerView = view.findViewById<RecyclerView>(R.id.movie_list_recycler_view)
        val movies = Movie.getMoviesListData()
        movieListRecyclerView.layoutManager = GridLayoutManager(view.context,2)
        if(movies.size > 0){
            movieListRecyclerView.visibility =android.view.View.VISIBLE

        }else{
            movieListRecyclerView.visibility =android.view.View.INVISIBLE

        }

        movieListRecyclerView.adapter = MoviesAdapter(movies, object : MoviesAdapter.OnMovieClickListener {
            override fun onMovieClick(movie: Movie) {
                clickListener.onMovieClick(movie)
            }
        })
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
        const val TAG = "movieList"
        fun newInstance(clickListener: MoviesAdapter.OnMovieClickListener): MoviesListFragment =
                MoviesListFragment(clickListener)
    }
}
    interface FragmentClick {
    fun showFilmDetails()
}
