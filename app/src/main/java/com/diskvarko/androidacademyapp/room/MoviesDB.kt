package com.diskvarko.androidacademyapp.room

import androidx.room.Database
import androidx.room.TypeConverter
import com.diskvarko.androidacademyapp.data.Actor
import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.network.data.Genre

class MoviesDB {
    @Database(entities = [Movie::class, Actor::class, Genre::class],
        version = 1)

}