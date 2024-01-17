package com.example.paging.pagingSource

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.repository.RemoteMoviesRepository
import javax.inject.Inject

class PopularTvShowsPagingSource @Inject constructor(
    private val repository: RemoteMoviesRepository
) :
    PagingSource<Int, TvShowsResults>() {
    override fun getRefreshKey(state: PagingState<Int, TvShowsResults>): Int? {
        return 1
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowsResults> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getPopularTvShows(page = currentPage)
            val responseData =
                mutableListOf<TvShowsResults>()
            response.data?.let { responseData.addAll(it.results) }
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}