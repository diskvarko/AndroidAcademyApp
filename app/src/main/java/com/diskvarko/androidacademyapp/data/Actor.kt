package com.diskvarko.androidacademyapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "actors")
data class Actor(

        @ColumnInfo(name = "id")
        val id: Int,

        @ColumnInfo(name = "picture")
        val picture: String,

        @ColumnInfo(name = "name")
        val name: String
)
