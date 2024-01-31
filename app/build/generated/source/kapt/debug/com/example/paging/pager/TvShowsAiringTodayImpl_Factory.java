// Generated by Dagger (https://dagger.dev).
package com.example.paging.pager;

import com.example.domain.repository.RemoteMoviesRepository;
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
public final class TvShowsAiringTodayImpl_Factory implements Factory<TvShowsAiringTodayImpl> {
  private final Provider<RemoteMoviesRepository> repositoryProvider;

  public TvShowsAiringTodayImpl_Factory(Provider<RemoteMoviesRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TvShowsAiringTodayImpl get() {
    return newInstance(repositoryProvider.get());
  }

  public static TvShowsAiringTodayImpl_Factory create(
      Provider<RemoteMoviesRepository> repositoryProvider) {
    return new TvShowsAiringTodayImpl_Factory(repositoryProvider);
  }

  public static TvShowsAiringTodayImpl newInstance(RemoteMoviesRepository repository) {
    return new TvShowsAiringTodayImpl(repository);
  }
}
