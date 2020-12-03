package com.diskvarko.androidacademyapp

data class Actor(
    val name: Int,
    val avatar: Int
) {
    fun actors(): List<Actor> {
        return when (name) {
            //cast Avengers
            R.id.name_film -> listOf(
                Actor(R.string.robert_downey_jr, R.drawable.robert),
                Actor(R.string.chris_hemsworth, R.drawable.chris_hams),
                Actor(R.string.chris_evans, R.drawable.chris_evans),
                Actor(R.string.mark_ruffalo, R.drawable.mark)
            )
            2 -> listOf(
                Actor(R.string.robert_downey_jr, R.drawable.robert),
                Actor(R.string.chris_hemsworth, R.drawable.chris_hams),
                Actor(R.string.chris_evans, R.drawable.chris_evans),
                Actor(R.string.mark_ruffalo, R.drawable.mark)
            )
            3 -> listOf(
                Actor(R.string.robert_downey_jr, R.drawable.robert),
                Actor(R.string.chris_hemsworth, R.drawable.chris_hams),
                Actor(R.string.chris_evans, R.drawable.chris_evans),
                Actor(R.string.mark_ruffalo, R.drawable.mark)
            )
            else -> listOf(
                Actor(R.string.robert_downey_jr, R.drawable.robert),
                Actor(R.string.chris_hemsworth, R.drawable.chris_hams),
                Actor(R.string.chris_evans, R.drawable.chris_evans),
                Actor(R.string.mark_ruffalo, R.drawable.mark)
            )
        }
    }
}