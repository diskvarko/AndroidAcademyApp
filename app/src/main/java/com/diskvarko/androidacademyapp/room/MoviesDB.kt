package com.diskvarko.androidacademyapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diskvarko.androidacademyapp.data.Actor
import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.network.data.Genre

const val NAME_DB = "movies database"
@Database(
    entities = [Movie::class, Actor::class, Genre::class],
    version = 1
)
abstract class MoviesDB : RoomDatabase() {


    abstract fun movieDao(): DaoMovie
    abstract fun actorsDao(): DaoActor
    abstract fun genreDao(): DaoGenre

    companion object {
        fun createDb(context: Context): MoviesDB =
            Room.databaseBuilder(
                context,
                MoviesDB::class.java,
                NAME_DB
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}