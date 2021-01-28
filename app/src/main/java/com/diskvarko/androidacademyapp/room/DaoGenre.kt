package com.diskvarko.androidacademyapp.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.diskvarko.androidacademyapp.data.Actor
import com.diskvarko.androidacademyapp.network.data.Genre

interface DaoGenre {
    @Query("SELECT * FROM genres")
    suspend fun getAll(): List<Genre>

    @Query("SELECT * FROM genres WHERE id = :id ")
    suspend fun getById(id: Int): Genre

}