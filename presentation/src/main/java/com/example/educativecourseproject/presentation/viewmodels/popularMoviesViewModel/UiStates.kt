package com.example.cinemaxv3.viewmodels.popularMoviesViewModel

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class UiStates<T:Any>(
    val isLoading: Boolean = false,
    val movies: LiveData<PagingData<T>>? = null,
    val error: String = ""
)
