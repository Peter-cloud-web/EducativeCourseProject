package com.example.cinemaxv3.viewmodels.favouriteMoviesViewModel;

import androidx.lifecycle.ViewModel;
import com.bumptech.glide.load.HttpException;
import com.example.domain.repository.RemoteMoviesRepository;
import com.example.domain.entities.model.favourites.FavouriteMovies;
import com.example.domain.repository.CachedMoviesRepository;
import com.example.domain.use_cases.favouritemovies_usecase.GetFavouriteMovieUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\f\u001a\u00020\u000fJ\u0014\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u0019R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/cinemaxv3/viewmodels/favouriteMoviesViewModel/FavouriteMoviesViewModel;", "Landroidx/lifecycle/ViewModel;", "favouriteMovieUseCase", "Lcom/example/domain/use_cases/favouritemovies_usecase/GetFavouriteMovieUseCase;", "repository", "Lcom/example/domain/repository/CachedMoviesRepository;", "(Lcom/example/domain/use_cases/favouritemovies_usecase/GetFavouriteMovieUseCase;Lcom/example/domain/repository/CachedMoviesRepository;)V", "_favouriteMovies", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/cinemaxv3/viewmodels/favouriteMoviesViewModel/FavouriteMoviesUiStates;", "favouriteMovies", "Lkotlinx/coroutines/flow/StateFlow;", "getFavouriteMovies", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteFavouriteMovie", "", "id", "", "handleFavouriteMoviesErrors", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "saveFavouriteMovies", "Lkotlinx/coroutines/Job;", "Lcom/example/domain/entities/model/favourites/FavouriteMovies;", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class FavouriteMoviesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.favouritemovies_usecase.GetFavouriteMovieUseCase favouriteMovieUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.repository.CachedMoviesRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.cinemaxv3.viewmodels.favouriteMoviesViewModel.FavouriteMoviesUiStates> _favouriteMovies = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.viewmodels.favouriteMoviesViewModel.FavouriteMoviesUiStates> favouriteMovies = null;
    
    @javax.inject.Inject
    public FavouriteMoviesViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.favouritemovies_usecase.GetFavouriteMovieUseCase favouriteMovieUseCase, @org.jetbrains.annotations.NotNull
    com.example.domain.repository.CachedMoviesRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.viewmodels.favouriteMoviesViewModel.FavouriteMoviesUiStates> getFavouriteMovies() {
        return null;
    }
    
    public final void getFavouriteMovies() {
    }
    
    private final java.lang.String handleFavouriteMoviesErrors(java.lang.Exception e) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job saveFavouriteMovies(@org.jetbrains.annotations.NotNull
    com.example.domain.entities.model.favourites.FavouriteMovies favouriteMovies) {
        return null;
    }
    
    public final void deleteFavouriteMovie(int id) {
    }
}