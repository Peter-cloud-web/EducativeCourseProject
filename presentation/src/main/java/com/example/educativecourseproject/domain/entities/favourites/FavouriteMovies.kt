package com.example.domain.entities.model.favourites

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "favourite_movies")

data class FavouriteMovies(
    val backdrop_path: String?,
    val overview: String?,
    val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val vote_average: Float,
    ) : Serializable
