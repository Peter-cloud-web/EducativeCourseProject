// Generated by Dagger (https://dagger.dev).
package com.example.cinemaxv3.viewmodels.upComingMoviesViewModel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.internal.lifecycle.HiltViewModelMap.KeySet")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class UpComingMoviesViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static UpComingMoviesViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(UpComingMoviesViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final UpComingMoviesViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new UpComingMoviesViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
