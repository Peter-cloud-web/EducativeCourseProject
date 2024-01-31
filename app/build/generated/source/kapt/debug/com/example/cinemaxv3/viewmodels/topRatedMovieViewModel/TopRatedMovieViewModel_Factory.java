// Generated by Dagger (https://dagger.dev).
package com.example.cinemaxv3.viewmodels.topRatedMovieViewModel;

import com.example.domain.use_cases.top_rated_movies_usecase.TopRatedMoviesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class TopRatedMovieViewModel_Factory implements Factory<TopRatedMovieViewModel> {
  private final Provider<TopRatedMoviesUseCase> getTopRatedMoviesUseCaseProvider;

  public TopRatedMovieViewModel_Factory(
      Provider<TopRatedMoviesUseCase> getTopRatedMoviesUseCaseProvider) {
    this.getTopRatedMoviesUseCaseProvider = getTopRatedMoviesUseCaseProvider;
  }

  @Override
  public TopRatedMovieViewModel get() {
    return newInstance(getTopRatedMoviesUseCaseProvider.get());
  }

  public static TopRatedMovieViewModel_Factory create(
      Provider<TopRatedMoviesUseCase> getTopRatedMoviesUseCaseProvider) {
    return new TopRatedMovieViewModel_Factory(getTopRatedMoviesUseCaseProvider);
  }

  public static TopRatedMovieViewModel newInstance(TopRatedMoviesUseCase getTopRatedMoviesUseCase) {
    return new TopRatedMovieViewModel(getTopRatedMoviesUseCase);
  }
}
