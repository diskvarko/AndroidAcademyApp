package com.diskvarko.androidacademyapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val avatar:ImageView = itemView.findViewById(R.id.actor_image)
    private val name:TextView = itemView.findViewById(R.id.actor_text)

    fun bind(actor: Actor){
        avatar.setImageResource(actor.avatar)
        name.text = actor.name.toString()

    }
}