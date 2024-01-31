package com.example.paging.pagingSource;

import android.net.http.HttpException;
import android.os.Build;
import androidx.annotation.RequiresExtension;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults;
import com.example.domain.repository.RemoteMoviesRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J#\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nJ+\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/paging/pagingSource/PopularTvShowsPagingSource;", "Landroidx/paging/PagingSource;", "", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "repository", "Lcom/example/domain/repository/RemoteMoviesRepository;", "(Lcom/example/domain/repository/RemoteMoviesRepository;)V", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presentation_debug"})
public final class PopularTvShowsPagingSource extends androidx.paging.PagingSource<java.lang.Integer, com.example.domain.entities.model.tvShowsResponse.TvShowsResults> {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.repository.RemoteMoviesRepository repository = null;
    
    @javax.inject.Inject
    public PopularTvShowsPagingSource(@org.jetbrains.annotations.NotNull
    com.example.domain.repository.RemoteMoviesRepository repository) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Integer getRefreshKey(@org.jetbrains.annotations.NotNull
    androidx.paging.PagingState<java.lang.Integer, com.example.domain.entities.model.tvShowsResponse.TvShowsResults> state) {
        return null;
    }
    
    @java.lang.Override
    @androidx.annotation.RequiresExtension(extension = android.os.Build.VERSION_CODES.S, version = 7)
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    androidx.paging.PagingSource.LoadParams<java.lang.Integer> params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.Integer, com.example.domain.entities.model.tvShowsResponse.TvShowsResults>> $completion) {
        return null;
    }
}