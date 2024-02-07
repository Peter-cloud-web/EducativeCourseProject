package com.example.cinemaxv3.viewmodels.popularMoviesViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bumptech.glide.load.HttpException
import com.example.cinemaxv3.models.Movie
import com.example.domain.use_cases.popularMovies_usecase.PopularMoviesUseCase
import com.example.domain.repository.RemoteMoviesRepository
import com.example.educativecourseproject.data.mappers.Mappers.toPopularMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: PopularMoviesUseCase,
    private val repository: RemoteMoviesRepository
) : ViewModel() {

    private val _popularMovieStates = MutableLiveData(UiStates<Movie>())
    val popularMoviesUiState = _popularMovieStates

    suspend fun getTopRatedMovie(): List<Movie>? =
        repository.getPopularMovies(1).data?.results?.map {
            it.toPopularMovie()
        }

    init {
        getPopularMovies()
    }

    fun getPopularMovies() {
        try {
            _popularMovieStates.value = UiStates(isLoading = true)
            val pagingData = getPopularMoviesUseCase().cachedIn(viewModelScope).asLiveData()
            _popularMovieStates.value = UiStates(movies = pagingData)
        } catch (e: Exception) {
            _popularMovieStates.value =
                UiStates(error = handlePopularMoviesErrors(e))
        }

    }
    private fun handlePopularMoviesErrors(e:Exception):String{
        return  when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }

}




