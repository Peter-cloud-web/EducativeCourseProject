package com.example.domain.entities.model.trailersResponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieTrailerResponse(
    @SerialName("id") val id: Int,
    @SerialName("results") val results: List<TrailerResults>
)