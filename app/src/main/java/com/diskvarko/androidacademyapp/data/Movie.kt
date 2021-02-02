package com.diskvarko.androidacademyapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diskvarko.androidacademyapp.network.data.Genre

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "poster")
    val poster: String,

    @ColumnInfo(name = "backdrop")
    val backdrop: String,

    @ColumnInfo(name = "ratings")
    val ratings: Float,

    @ColumnInfo(name = "numberOfRatings")
    val numberOfRatings: Long,

    @ColumnInfo(name = "minimumAge")
    val minimumAge: Int,

    @ColumnInfo(name = "runtime")
    val runtime: Int,

    @ColumnInfo(name = "genres")
    val genres: List<Genre>,

    @ColumnInfo(name = "actors")
    val actors: List<Actor>
)