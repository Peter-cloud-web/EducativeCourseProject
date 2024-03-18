package com.example.cinemaxv3.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewsResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val review: List<Review>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)

@Serializable
data class Review(
    @SerialName("author"         ) var author        : String?        = null,
    @SerialName("author_details" ) var authorDetails : AuthorDetails,
    @SerialName("content"        ) var content       : String?        = null,
    @SerialName("created_at"     ) var createdAt     : String?        = null,
    @SerialName("id"             ) var id            : String?        = null,
    @SerialName("updated_at"     ) var updatedAt     : String?        = null,
    @SerialName("url"            ) var url           : String?        = null
)

@Serializable
data class AuthorDetails(
    @SerialName("name")
    val name: String,
    @SerialName("username")
    val userName: String,
    @SerialName("avatar_path")
    val avatarPath: String?,
    @SerialName("rating")
    val rating: Double?,
)