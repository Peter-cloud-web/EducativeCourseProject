// Generated by Dagger (https://dagger.dev).
package com.example.cinemaxv3.view.ui.adapter;

import coil.ImageLoader;
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
public final class MovieCastsAdapter_Factory implements Factory<MovieCastsAdapter> {
  private final Provider<ImageLoader> imageLoaderProvider;

  public MovieCastsAdapter_Factory(Provider<ImageLoader> imageLoaderProvider) {
    this.imageLoaderProvider = imageLoaderProvider;
  }

  @Override
  public MovieCastsAdapter get() {
    return newInstance(imageLoaderProvider.get());
  }

  public static MovieCastsAdapter_Factory create(Provider<ImageLoader> imageLoaderProvider) {
    return new MovieCastsAdapter_Factory(imageLoaderProvider);
  }

  public static MovieCastsAdapter newInstance(ImageLoader imageLoader) {
    return new MovieCastsAdapter(imageLoader);
  }
}
