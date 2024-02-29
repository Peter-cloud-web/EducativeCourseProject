package com.example.cinemaxv3.viewmodels.popularMoviesViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bumptech.glide.load.HttpException
import com.example.cinemaxv3.models.Movie
import com.example.domain.repository.RemoteMoviesRepository
import com.example.domain.use_cases.popularMovies_usecase.PopularMoviesUseCase
import com.example.educativecourseproject.data.mappers.Mappers.toPopularMovie
import com.example.educativecourseproject.data.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: PopularMoviesUseCase,
    private val repository: RemoteMoviesRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val _popularMovieStates = MutableLiveData(UiStates<Movie>())
    val popularMoviesUiState = _popularMovieStates

    suspend fun getTopRatedMovie(): List<Movie>? =
        repository.getPopularMovies(1).data?.results?.map {
            it.toPopularMovie()
        }

    init {
        viewModelScope.launch {
            getPopularMovies()
        }
    }

    suspend fun getPopularMovies() {
        try {
            _popularMovieStates.postValue(UiStates(isLoading = true))
            delay(5000)
            val pagingData =
                getPopularMoviesUseCase().cachedIn(viewModelScope).asLiveData()
            _popularMovieStates.postValue(UiStates(movies = pagingData))
        } catch (e: Exception) {
            _popularMovieStates.value =
                UiStates(error = handlePopularMoviesErrors(e))
        }
    }

    private fun handlePopularMoviesErrors(e: Exception): String {
        return when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }

}




