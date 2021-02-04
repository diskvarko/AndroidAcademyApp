package com.diskvarko.androidacademyapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diskvarko.androidacademyapp.data.Movie

@Dao
interface DaoMovie {

    @Query("SELECT * FROM movies")
    suspend fun getAll(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(movies: List<Movie>)

    @Query("SELECT * FROM movies WHERE id = :id ")
    suspend fun getMovieById(id: Int): Movie

}