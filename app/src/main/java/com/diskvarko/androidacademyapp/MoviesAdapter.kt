package com.diskvarko.androidacademyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(var movies: List<Movie>,
                    context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(listMovie : View) :RecyclerView.ViewHolder(listMovie){
        val name = itemView.findViewById<TextView>(R.id.name_film)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    fun getCount():Int = movies.size

    fun getView(position: Int, parent: ViewGroup): View {

        val row = inflater.inflate(R.layout.fragment_movies_list,parent,false)

        val poster: ImageView = row.findViewById(R.id.avengers_poster)
        val name: TextView = row.findViewById(R.id.name_film)
        val rating: RatingBar = row.findViewById(R.id.ratingBar)
        val ratingAge: TextView = row.findViewById(R.id.rating)
        val duration: TextView = row.findViewById(R.id.duration)
        val review: TextView = row.findViewById(R.id.review)


        val movie = movies[position]

        return row

    }
}