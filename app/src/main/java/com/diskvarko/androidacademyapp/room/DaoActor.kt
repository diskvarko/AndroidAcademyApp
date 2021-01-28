package com.diskvarko.androidacademyapp.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.diskvarko.androidacademyapp.data.Actor
import com.diskvarko.androidacademyapp.data.Movie

interface DaoActor {
    @Query("SELECT * FROM actors")
    suspend fun getAll(): List<Actor>

    @Query("SELECT * FROM actors WHERE id = :id ")
    suspend fun getById(id: Int): Actor

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(movies: List<Actor>)

    @Update
    suspend fun updateActors(actor: Actor)
}