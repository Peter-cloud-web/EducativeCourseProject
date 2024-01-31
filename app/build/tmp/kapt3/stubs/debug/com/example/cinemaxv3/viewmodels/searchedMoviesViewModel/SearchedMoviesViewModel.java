package com.example.cinemaxv3.viewmodels.searchedMoviesViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.domain.movieDto.MovieResponseDto;
import com.example.domain.use_cases.searchedMovies_usecase.SearchMoviesUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/cinemaxv3/viewmodels/searchedMoviesViewModel/SearchedMoviesViewModel;", "Landroidx/lifecycle/ViewModel;", "searchMoviesUseCase", "Lcom/example/domain/use_cases/searchedMovies_usecase/SearchMoviesUseCase;", "(Lcom/example/domain/use_cases/searchedMovies_usecase/SearchMoviesUseCase;)V", "SearchResponse", "Landroidx/lifecycle/LiveData;", "Lcom/example/domain/movieDto/MovieResponseDto;", "getSearchResponse", "()Landroidx/lifecycle/LiveData;", "_searchMoviesResponse", "Landroidx/lifecycle/MutableLiveData;", "searchMovies", "", "query", "", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SearchedMoviesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.searchedMovies_usecase.SearchMoviesUseCase searchMoviesUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.example.domain.movieDto.MovieResponseDto> _searchMoviesResponse = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.example.domain.movieDto.MovieResponseDto> SearchResponse = null;
    
    @javax.inject.Inject
    public SearchedMoviesViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.searchedMovies_usecase.SearchMoviesUseCase searchMoviesUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.domain.movieDto.MovieResponseDto> getSearchResponse() {
        return null;
    }
    
    public final void searchMovies(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
}