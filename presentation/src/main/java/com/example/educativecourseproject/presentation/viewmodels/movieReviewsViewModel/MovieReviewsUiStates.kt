package com.example.cinemaxv3.viewmodels.movieReviewsViewModel

import androidx.lifecycle.LiveData
import com.example.cinemaxv3.models.responses.Review
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MovieReviewsUiStates (
    val isLoading: Boolean = false,
    val reviews : LiveData<Review>? = null,
    val error:String = ""

)