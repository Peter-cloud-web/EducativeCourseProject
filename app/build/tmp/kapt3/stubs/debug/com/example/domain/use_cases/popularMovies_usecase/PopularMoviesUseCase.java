package com.example.domain.use_cases.popularMovies_usecase;

import androidx.paging.ExperimentalPagingApi;
import androidx.paging.PagingData;
import com.example.cinemaxv3.models.Movie;
import com.example.domain.pager.PopularMoviesPager;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/domain/use_cases/popularMovies_usecase/PopularMoviesUseCase;", "", "popularMoviesPager", "Lcom/example/domain/pager/PopularMoviesPager;", "(Lcom/example/domain/pager/PopularMoviesPager;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/cinemaxv3/models/Movie;", "presentation_debug"})
public final class PopularMoviesUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.pager.PopularMoviesPager popularMoviesPager = null;
    
    @javax.inject.Inject
    public PopularMoviesUseCase(@org.jetbrains.annotations.NotNull
    com.example.domain.pager.PopularMoviesPager popularMoviesPager) {
        super();
    }
    
    @kotlin.OptIn(markerClass = {androidx.paging.ExperimentalPagingApi.class})
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.cinemaxv3.models.Movie>> invoke() {
        return null;
    }
}