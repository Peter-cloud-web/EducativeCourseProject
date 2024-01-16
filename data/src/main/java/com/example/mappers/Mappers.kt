package com.example.mappers

import com.example.domain.dto.PopularMovieDto
import com.example.domain.dto.TopRatedMoviesDto
import com.example.domain.dto.UpComingMoviesDto
import com.example.domain.entities.popularMovies.PopularMovie
import com.example.domain.entities.topRatedMovies.TopRatedMovie
import com.example.domain.entities.upcomingMovies.UpcomingMovie

object Mappers {
    fun PopularMovieDto.toPopularMovie(): PopularMovie {
        return PopularMovie(
            backdrop_path = backdrop_path,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            page = 1
        )
    }

    fun TopRatedMoviesDto.toTopRatedMovie(): TopRatedMovie {
        return TopRatedMovie(
            backdrop_path = backdrop_path,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            page = 1
        )
    }

    fun UpComingMoviesDto.toUpComingMovies(): UpcomingMovie {
        return UpcomingMovie(
            backdrop_path = backdrop_path,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            page = 1
        )
    }
}