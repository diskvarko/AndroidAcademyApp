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


}
private lateinit var INSTANCE: MoviesDB

fun getDatabase(context: Context): MoviesDB {
    synchronized(MoviesDB::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesDB::class.java,
                    NAME_DB
            )
                    .fallbackToDestructiveMigration()
                    .build()

        }
    }
    return INSTANCE
}

