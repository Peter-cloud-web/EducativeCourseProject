package com.example.educativecourseproject.domain.entities.MovieCasts

data class MovieCastResponse(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)