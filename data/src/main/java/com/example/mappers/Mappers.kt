package com.example.mappers

import com.example.educativecourseproject.domain.dto.PopularMovieDto
import com.example.educativecourseproject.domain.dto.TopRatedMoviesDto
import com.example.educativecourseproject.domain.dto.UpComingMoviesDto
import com.example.educativecourseproject.domain.entities.popularMovies.PopularMovie
import com.example.educativecourseproject.domain.entities.topRatedMovies.TopRatedMovie
import com.example.educativecourseproject.domain.entities.upcomingMovies.UpcomingMovie

object Mappers {
    fun com.example.educativecourseproject.domain.dto.PopularMovieDto.toPopularMovie(): com.example.educativecourseproject.domain.entities.popularMovies.PopularMovie {
        return com.example.educativecourseproject.domain.entities.popularMovies.PopularMovie(
            backdrop_path = backdrop_path,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            page = 1
        )
    }

    fun com.example.educativecourseproject.domain.dto.TopRatedMoviesDto.toTopRatedMovie(): com.example.educativecourseproject.domain.entities.topRatedMovies.TopRatedMovie {
        return com.example.educativecourseproject.domain.entities.topRatedMovies.TopRatedMovie(
            backdrop_path = backdrop_path,
            overview = overview,
            poster_path = poster_path,
            id = id,
            title = title,
            vote_average = vote_average,
            page = 1
        )
    }

    fun com.example.educativecourseproject.domain.dto.UpComingMoviesDto.toUpComingMovies(): com.example.educativecourseproject.domain.entities.upcomingMovies.UpcomingMovie {
        return com.example.educativecourseproject.domain.entities.upcomingMovies.UpcomingMovie(
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