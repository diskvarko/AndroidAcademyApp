package com.diskvarko.androidacademyapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.diskvarko.androidacademyapp.data.Actor

class ActorsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

     private val avatar:ImageView = view.findViewById(R.id.actor_image)
     private val name:TextView = view.findViewById(R.id.actor_text)

     fun bind(actor: Actor){
          avatar.load(actor.picture)
          name.text = actor.name
     }
}