package com.diskvarko.androidacademyapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diskvarko.androidacademyapp.data.Actor
//import coil.load
import kotlinx.android.synthetic.main.view_holder_actors.view.*

class ActorsAdapter() : RecyclerView.Adapter<ActorsViewHolder>() {

    private var cast: List<Actor> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val someView = inflater.inflate(R.layout.view_holder_actors,parent,false)
       return ActorsViewHolder(someView)
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        holder.bind(cast[position])
    }

    override fun getItemCount(): Int {
        return cast.size
    }

    fun updateActors(newActors: List<Actor>) {
        cast = newActors
        notifyDataSetChanged()
    }
}