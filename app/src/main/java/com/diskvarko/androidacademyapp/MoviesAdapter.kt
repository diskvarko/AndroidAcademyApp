package com.diskvarko.androidacademyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class MoviesAdapter(
    private val movies: List<Movie>)
    : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val background: ImageView = view.findViewById(R.id.avengers_poster)
        val name: TextView = view.findViewById(R.id.name_film)
        val tag: TextView = view.findViewById(R.id.genre)
       // val ratingStars = view.findViewById<RatingBar>(R.id.ratingBar)!!
        val rating: TextView = view.findViewById(R.id.review)
        val time: TextView = view.findViewById(R.id.duration)
       // val pgRating: TextView = view.findViewById(R.id.rating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val movieView = inflater.inflate(R.layout.view_holder_movie, parent, false)
        return ViewHolder(movieView)
    }


        override fun getItemCount(): Int {
            return movies.size
        }

        interface OnRecyclerItemClicked {
            fun onClick(movieNum: Int)
        }

        fun getCount(): Int = movies.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movies[position].apply {
            holder.background.load(background)
            holder.name.text = name
            holder.rating.text = "$reviews Reviews"
            holder.tag.text = tag
            holder.time.text = "$time min"
          //  holder.ratingStars.setProgress(ratingStars, true)
            //holder.pgRating.text = pgRating
        }
    }


}