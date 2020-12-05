package com.diskvarko.androidacademyapp

data class Actor(

        val avatar: Int,
        val name: String

) {
    companion object {
        fun actors(): ArrayList<Actor> {
            val cast = ArrayList<Actor>()
            //cast Avengers
            cast.apply {
                add(Actor(R.drawable.robert, "Robert Downey Jr."))
                add(Actor(R.drawable.chris_hams, "Chris Hemsworth"))
                add(Actor(R.drawable.chris_evans, "Chris Evans"))
                add(Actor(R.drawable.mark, "Mark Ruffalo"))
            }
            return cast
        }
    }
}
