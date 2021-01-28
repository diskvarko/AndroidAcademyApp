package com.diskvarko.androidacademyapp.network.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
data class Genres(
    val genres: List<Genre>
)

@Serializable
@Entity(tableName = "genres")
data class Genre(

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "id")
    val name: String
)