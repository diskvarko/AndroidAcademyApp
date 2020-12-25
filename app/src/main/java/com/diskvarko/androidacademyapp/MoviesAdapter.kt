package com.diskvarko.androidacademyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.diskvarko.androidacademyapp.data.Movie

class MoviesAdapter(private val movieClickListener: OnMovieClickListener)
    : RecyclerView.Adapter<MoviesViewHolder>() {

    private  var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val movieView = inflater.inflate(R.layout.view_holder_movie, parent, false)
        return MoviesViewHolder(movieView, movieClickListener )
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    fun setMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    fun getCount(): Int = movies.size

    interface OnMovieClickListener {
        fun onMovieClick(movie: Movie)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
       holder.bind(movies[position])
    }
}