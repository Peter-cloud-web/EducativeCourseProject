package com.example.educativecourseproject.domain.entities.popularMovies

data class PopularMovie(
    val backdrop_path: String?,
    val id: Int?,
    val overview: String?,
    val poster_path: String?,
    val title: String?,
    val vote_average: Double?,
    var page: Int?
)