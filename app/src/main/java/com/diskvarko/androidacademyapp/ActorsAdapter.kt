package com.diskvarko.androidacademyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ActorsAdapter (
    var actors: List<Actor>,
    context: Context
) : RecyclerView.Adapter<ActorsViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
       return ActorsViewHolder(inflater.inflate(R.layout.fragment_movies_details,parent,false))
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = actors.size

    fun getItem(position: Int):Actor = actors[position]
}