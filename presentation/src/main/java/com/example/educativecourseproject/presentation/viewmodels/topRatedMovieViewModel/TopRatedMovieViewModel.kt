package com.example.cinemaxv3.viewmodels.topRatedMovieViewModel

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates
import com.example.domain.use_cases.top_rated_movies_usecase.TopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import java.io.IOException
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class TopRatedMovieViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: TopRatedMoviesUseCase
) : ViewModel() {

    private val _topRatedMovieStates = MutableLiveData(UiStates<TopRatedMovies>())
    val topRatedMovieUiState: LiveData<UiStates<TopRatedMovies>> get() =  _topRatedMovieStates

    init {
        getTopRatedMovies()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getTopRatedMovies() {
        try {
                _topRatedMovieStates.postValue(UiStates(isLoading = true))
                val pagingData = getTopRatedMoviesUseCase().cachedIn(viewModelScope).asLiveData()
                _topRatedMovieStates.postValue(UiStates(movies = pagingData))
        } catch (e: Exception) {
            _topRatedMovieStates.postValue(UiStates(error = handleTopRatedMoviesErrors(e)))
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
