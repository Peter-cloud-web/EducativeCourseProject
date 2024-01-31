package com.example.paging.pager;

import androidx.paging.ExperimentalPagingApi;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults;
import com.example.domain.pager.ToPRatedTvShowsPager;
import com.example.domain.repository.RemoteMoviesRepository;
import com.example.educativecourseproject.data.db.MovieDatabase;
import com.example.paging.mediators.TopRatedTvShowsMediator;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/paging/pager/TopRatedTvShowsImpl;", "Lcom/example/domain/pager/ToPRatedTvShowsPager;", "movieDatabase", "Lcom/example/educativecourseproject/data/db/MovieDatabase;", "repository", "Lcom/example/domain/repository/RemoteMoviesRepository;", "(Lcom/example/educativecourseproject/data/db/MovieDatabase;Lcom/example/domain/repository/RemoteMoviesRepository;)V", "getTopRatedTvShows", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "presentation_debug"})
public final class TopRatedTvShowsImpl implements com.example.domain.pager.ToPRatedTvShowsPager {
    @org.jetbrains.annotations.NotNull
    private final com.example.educativecourseproject.data.db.MovieDatabase movieDatabase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.repository.RemoteMoviesRepository repository = null;
    
    @javax.inject.Inject
    public TopRatedTvShowsImpl(@org.jetbrains.annotations.NotNull
    com.example.educativecourseproject.data.db.MovieDatabase movieDatabase, @org.jetbrains.annotations.NotNull
    com.example.domain.repository.RemoteMoviesRepository repository) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.domain.entities.model.tvShowsResponse.TvShowsResults>> getTopRatedTvShows() {
        return null;
    }
}