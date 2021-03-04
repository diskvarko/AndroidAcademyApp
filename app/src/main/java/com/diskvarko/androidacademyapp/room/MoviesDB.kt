package com.diskvarko.androidacademyapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diskvarko.androidacademyapp.data.Movie

const val NAME_DB = "movies database"

@Database(
        entities = [Movie::class],
        version = 1
)
@TypeConverters(Converters::class)
abstract class MoviesDB : RoomDatabase() {


    abstract fun movieDao(): DaoMovie


    companion object {

        fun createDb(context: Context): MoviesDB = Room.databaseBuilder(
                context,
                MoviesDB::class.java,
                NAME_DB
        )
                .fallbackToDestructiveMigration()
                .build()

    }
}

