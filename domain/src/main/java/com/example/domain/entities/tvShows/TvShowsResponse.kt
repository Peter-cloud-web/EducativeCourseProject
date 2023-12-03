package com.example.domain.entities.tvShows

data class TvShowsResponse(
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)