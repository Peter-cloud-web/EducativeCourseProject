package com.example.data

import com.example.domain.dto.PopularMovieDto
import com.example.domain.entities.popularMovies.PopularMovie
import com.example.mappers.Mappers
import com.example.mappers.Mappers.toPopularMovie
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MappersUnitTest {
    @Test
    fun testPopularMovieDtoToPopularMovie() {
        val dto = PopularMovieDto(
            adult = true,
            backdrop_path = "backdrop.jpg",
            genre_ids = null,
            original_language = "English",
            original_title = "Black panther",
            overview = "A thrilling movie...",
            popularity = null,
            poster_path = "poster.jpg",
            release_date = null,
            id = 123,
            title = "The Movie Title",
            video = false,
            vote_average = 8.5,
            vote_count = null
        )

        val expectedMovie = PopularMovie(
            backdrop_path = "backdrop.jpg",
            overview = "A thrilling movie...",
            poster_path = "poster.jpg",
            id = 123,
            title = "The Movie Title",
            vote_average = 8.5,
            page = 1
        )

        val actualMovie = dto.toPopularMovie()

        assertEquals(expectedMovie, actualMovie)
    }
}