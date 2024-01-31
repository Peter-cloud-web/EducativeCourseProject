package com.example.cinemaxv3.viewmodels.tvShowsAiringTodayViewModel;

import androidx.lifecycle.ViewModel;
import com.bumptech.glide.load.HttpException;
import com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults;
import com.example.domain.use_cases.TVshows_airingToday_usecase.TvShowsAringTodayUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/cinemaxv3/viewmodels/tvShowsAiringTodayViewModel/TvShowsAiringTodayViewModel;", "Landroidx/lifecycle/ViewModel;", "tvShowsAiringTodayUseCase", "Lcom/example/domain/use_cases/TVshows_airingToday_usecase/TvShowsAringTodayUseCase;", "(Lcom/example/domain/use_cases/TVshows_airingToday_usecase/TvShowsAringTodayUseCase;)V", "_tvShowsAiringTodayUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/cinemaxv3/viewmodels/popularMoviesViewModel/UiStates;", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "tvShowsAiringTodayUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getTvShowsAiringTodayUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getTvShowsAiringToday", "", "handleTvShowsAiringTodayErrors", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class TvShowsAiringTodayViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.TVshows_airingToday_usecase.TvShowsAringTodayUseCase tvShowsAiringTodayUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates<com.example.domain.entities.model.tvShowsResponse.TvShowsResults>> _tvShowsAiringTodayUiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates<com.example.domain.entities.model.tvShowsResponse.TvShowsResults>> tvShowsAiringTodayUiState = null;
    
    @javax.inject.Inject
    public TvShowsAiringTodayViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.TVshows_airingToday_usecase.TvShowsAringTodayUseCase tvShowsAiringTodayUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates<com.example.domain.entities.model.tvShowsResponse.TvShowsResults>> getTvShowsAiringTodayUiState() {
        return null;
    }
    
    public final void getTvShowsAiringToday() {
    }
    
    private final java.lang.String handleTvShowsAiringTodayErrors(java.lang.Exception e) {
        return null;
    }
}