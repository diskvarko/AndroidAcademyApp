package com.diskvarko.androidacademyapp.movieList

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.diskvarko.androidacademyapp.R
import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.network.data.Genre

class MoviesViewHolder(
    view: View,
    private val onMovieClickListener: MoviesAdapter.OnMovieClickListener
) :
    RecyclerView.ViewHolder(view) {
    private val background: ImageView = view.findViewById(R.id.avengers_poster)
    private val name: TextView = view.findViewById(R.id.name_film)
    private val tag: TextView = view.findViewById(R.id.genre)
    private val ratingStars = view.findViewById<RatingBar>(R.id.ratingBar)!!
    private val review: TextView = view.findViewById(R.id.review)
    private val time: TextView = view.findViewById(R.id.duration)
    private val pgRating: TextView = view.findViewById(R.id.ratingAge)
    private val clickItem: View = view.findViewById(R.id.movieClick)

    fun bind(movie: Movie) {
        background.load(movie.poster)
        pgRating.text = "${movie.minimumAge}+"
        name.text = movie.title
        time.text = "${movie.runtime} MIN"
        ratingStars.rating = setRating(movie.ratings)
        review.text = "${movie.numberOfRatings} REVIEWS"
        tag.text = setTags(movie.genres)

        clickItem.setOnClickListener {
            onMovieClickListener.onMovieClick(movie)
        }
    }

    private fun setRating(rating10: Float): Float = rating10 / 2.0f

    private fun setTags(genres: List<Genre>): String = genres.joinToString(", ") { it.name }

}
