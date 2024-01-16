package com.example.educativecourseproject.domain.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class PopularMovieResponseDto(
    @SerialName("page") val page: Int,
    @SerialName("results") val results: List<PopularMovieDto>,
    @SerialName("total_pages") val pages: Int,
    @SerialName("total_results") val totalResults: Int
)

@kotlinx.serialization.Serializable
data class TopRatedMovieResponseDto(
    @SerialName("page") val page: Int,
    @SerialName("results") val movies: List<TopRatedMoviesDto>,
    @SerialName("total_pages") val pages: Int,
    @SerialName("total_results") val totalResults: Int
)

@Serializable
data class UpComingMovieResponseDto(
    @SerialName("page") val page: Int,
    @SerialName("results") val movies: List<UpComingMoviesDto>,
    @SerialName("total_pages") val pages: Int,
    @SerialName("total_results") val totalResults: Int
)
