// Generated by Dagger (https://dagger.dev).
package com.example.cinemaxv3.viewmodels.tvShowsAiringTodayViewModel;

import com.example.domain.use_cases.TVshows_airingToday_usecase.TvShowsAringTodayUseCase;
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
public final class TvShowsAiringTodayViewModel_Factory implements Factory<TvShowsAiringTodayViewModel> {
  private final Provider<TvShowsAringTodayUseCase> tvShowsAiringTodayUseCaseProvider;

  public TvShowsAiringTodayViewModel_Factory(
      Provider<TvShowsAringTodayUseCase> tvShowsAiringTodayUseCaseProvider) {
    this.tvShowsAiringTodayUseCaseProvider = tvShowsAiringTodayUseCaseProvider;
  }

  @Override
  public TvShowsAiringTodayViewModel get() {
    return newInstance(tvShowsAiringTodayUseCaseProvider.get());
  }

  public static TvShowsAiringTodayViewModel_Factory create(
      Provider<TvShowsAringTodayUseCase> tvShowsAiringTodayUseCaseProvider) {
    return new TvShowsAiringTodayViewModel_Factory(tvShowsAiringTodayUseCaseProvider);
  }

  public static TvShowsAiringTodayViewModel newInstance(
      TvShowsAringTodayUseCase tvShowsAiringTodayUseCase) {
    return new TvShowsAiringTodayViewModel(tvShowsAiringTodayUseCase);
  }
}
