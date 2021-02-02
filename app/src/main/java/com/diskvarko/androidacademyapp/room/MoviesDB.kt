package com.diskvarko.androidacademyapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diskvarko.androidacademyapp.data.Actor
import com.diskvarko.androidacademyapp.data.Movie
import com.diskvarko.androidacademyapp.network.data.Genre

const val NAME_DB = "movies database"
@Database(
    entities = [Movie::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MoviesDB : RoomDatabase() {


    abstract fun movieDao(): DaoMovie


    companion object {
        @Volatile
        private var INSTANCE: MoviesDB? = null

        fun createDb(context: Context): MoviesDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context,
                        MoviesDB::class.java,
                        NAME_DB
                    )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}