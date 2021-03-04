package com.diskvarko.androidacademyapp.movieDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diskvarko.androidacademyapp.R
import com.diskvarko.androidacademyapp.data.Actor

class ActorsAdapter(private var cast: List<Actor>) : RecyclerView.Adapter<ActorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val someView = inflater.inflate(R.layout.view_holder_actors, parent, false)
        return ActorsViewHolder(someView)
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        holder.bind(cast[position])
    }

    override fun getItemCount(): Int = cast.size

    fun updateActors(newActors: List<Actor>) {
        cast = newActors
        notifyDataSetChanged()
    }
}