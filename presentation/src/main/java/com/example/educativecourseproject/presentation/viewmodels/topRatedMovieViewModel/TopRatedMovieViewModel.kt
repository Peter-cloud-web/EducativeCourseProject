package com.example.cinemaxv3.viewmodels.topRatedMovieViewModel

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates
import com.example.domain.use_cases.top_rated_movies_usecase.TopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class TopRatedMovieViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: TopRatedMoviesUseCase
) : ViewModel() {

    private val _topRatedMovieStates = MutableStateFlow(UiStates<TopRatedMovies>())
    val topRatedMovieUiState = _topRatedMovieStates.asStateFlow()

    init {
        getTopRatedMovies()
    }

    fun getTopRatedMovies() {
        try {
            _topRatedMovieStates.value = UiStates(isLoading = true)
            val pagingData = getTopRatedMoviesUseCase().cachedIn(viewModelScope)
            _topRatedMovieStates.value = UiStates(movies = pagingData)
        } catch (e: Exception) {
            _topRatedMovieStates.value =
                UiStates(error = handleTopRatedMoviesErrors(e))
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun handleTopRatedMoviesErrors(e: Exception): String {
        return when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }


}
