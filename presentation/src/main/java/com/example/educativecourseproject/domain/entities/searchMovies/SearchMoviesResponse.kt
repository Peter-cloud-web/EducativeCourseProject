package com.example.educativecourseproject.domain.entities.searchMovies

data class SearchMoviesResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)