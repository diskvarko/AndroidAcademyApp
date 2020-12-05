package com.diskvarko.androidacademyapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
//import coil.load
import kotlinx.android.synthetic.main.view_holder_actors.view.*

class ActorsAdapter(
    private val cast: List<Actor>
      //  context: MoviesDetailsFragment
) : RecyclerView.Adapter<ActorsViewHolder>() {


    //private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val someView = inflater.inflate(R.layout.view_holder_actors,parent,false)
       return ActorsViewHolder(someView)
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        holder.avatar.load(cast[position].avatar)
        holder.name.text = cast[position].name
    }

    override fun getItemCount(): Int {
        return cast.size
    }

   // private fun getItem(position: Int):Actor = cast[position]
}