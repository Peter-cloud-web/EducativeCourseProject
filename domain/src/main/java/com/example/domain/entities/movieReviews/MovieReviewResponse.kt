package com.example.domain.entities.movieReviews

data class MovieReviewResponse(
    val id: Int,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)