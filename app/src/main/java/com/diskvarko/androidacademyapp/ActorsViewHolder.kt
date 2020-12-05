package com.diskvarko.androidacademyapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

     val avatar:ImageView = view.findViewById(R.id.actor_image)
     val name:TextView = view.findViewById(R.id.actor_text)

}