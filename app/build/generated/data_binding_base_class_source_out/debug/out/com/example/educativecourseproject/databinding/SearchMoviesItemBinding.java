// Generated by view binder compiler. Do not edit!
package com.example.educativecourseproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.educativecourseproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SearchMoviesItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView aboutMovie;

  @NonNull
  public final ConstraintLayout cardView;

  @NonNull
  public final ImageView imageMovies;

  @NonNull
  public final TextView movieTitle;

  @NonNull
  public final TextView ratingMovie;

  @NonNull
  public final View view;

  private SearchMoviesItemBinding(@NonNull ConstraintLayout rootView, @NonNull TextView aboutMovie,
      @NonNull ConstraintLayout cardView, @NonNull ImageView imageMovies,
      @NonNull TextView movieTitle, @NonNull TextView ratingMovie, @NonNull View view) {
    this.rootView = rootView;
    this.aboutMovie = aboutMovie;
    this.cardView = cardView;
    this.imageMovies = imageMovies;
    this.movieTitle = movieTitle;
    this.ratingMovie = ratingMovie;
    this.view = view;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SearchMoviesItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SearchMoviesItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.search_movies_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SearchMoviesItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aboutMovie;
      TextView aboutMovie = ViewBindings.findChildViewById(rootView, id);
      if (aboutMovie == null) {
        break missingId;
      }

      ConstraintLayout cardView = (ConstraintLayout) rootView;

      id = R.id.image_movies;
      ImageView imageMovies = ViewBindings.findChildViewById(rootView, id);
      if (imageMovies == null) {
        break missingId;
      }

      id = R.id.movieTitle;
      TextView movieTitle = ViewBindings.findChildViewById(rootView, id);
      if (movieTitle == null) {
        break missingId;
      }

      id = R.id.ratingMovie;
      TextView ratingMovie = ViewBindings.findChildViewById(rootView, id);
      if (ratingMovie == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      return new SearchMoviesItemBinding((ConstraintLayout) rootView, aboutMovie, cardView,
          imageMovies, movieTitle, ratingMovie, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
