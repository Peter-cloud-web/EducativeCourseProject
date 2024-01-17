package com.example.cinemaxv3.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.db.dao.movieDaos.converters.ListConverter
import java.io.Serializable


@Entity(tableName = "movies")
@TypeConverters(ListConverter::class)
data class Movie(
    val backdrop_path: String?,
    val overview: String?,
    val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val vote_average: Double,
    var page: Int?
) : Serializable


@Entity(tableName = "toprated_movies")
@TypeConverters(ListConverter::class)
data class TopRatedMovies(
    val backdrop_path: String?,
    val overview: String?,
    val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val vote_average: Double,
    var page: Int?
) : Serializable

@Entity(tableName = "upcoming_movies")
@TypeConverters(ListConverter::class)
data class UpComingMovies(
    val backdrop_path: String?,
    val overview: String?,
    val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val vote_average: Double,
    var page: Int?
) : Serializable
