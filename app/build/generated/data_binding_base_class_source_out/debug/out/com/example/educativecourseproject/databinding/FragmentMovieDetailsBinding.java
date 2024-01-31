// Generated by view binder compiler. Do not edit!
package com.example.educativecourseproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.educativecourseproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMovieDetailsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView TextView3;

  @NonNull
  public final ImageView backdropImage;

  @NonNull
  public final Button btnTrailer;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView movieDescription;

  @NonNull
  public final ImageView movieImage;

  @NonNull
  public final TextView movieTitle;

  @NonNull
  public final Button playButton;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final ImageView shareMovie;

  @NonNull
  public final ImageView watchlist;

  private FragmentMovieDetailsBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView TextView3, @NonNull ImageView backdropImage, @NonNull Button btnTrailer,
      @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull TextView movieDescription,
      @NonNull ImageView movieImage, @NonNull TextView movieTitle, @NonNull Button playButton,
      @NonNull ProgressBar progress, @NonNull ImageView shareMovie, @NonNull ImageView watchlist) {
    this.rootView = rootView;
    this.TextView3 = TextView3;
    this.backdropImage = backdropImage;
    this.btnTrailer = btnTrailer;
    this.cardView = cardView;
    this.imageView = imageView;
    this.movieDescription = movieDescription;
    this.movieImage = movieImage;
    this.movieTitle = movieTitle;
    this.playButton = playButton;
    this.progress = progress;
    this.shareMovie = shareMovie;
    this.watchlist = watchlist;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMovieDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMovieDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_movie_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMovieDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.TextView3;
      TextView TextView3 = ViewBindings.findChildViewById(rootView, id);
      if (TextView3 == null) {
        break missingId;
      }

      id = R.id.backdropImage;
      ImageView backdropImage = ViewBindings.findChildViewById(rootView, id);
      if (backdropImage == null) {
        break missingId;
      }

      id = R.id.btnTrailer;
      Button btnTrailer = ViewBindings.findChildViewById(rootView, id);
      if (btnTrailer == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.movie_description;
      TextView movieDescription = ViewBindings.findChildViewById(rootView, id);
      if (movieDescription == null) {
        break missingId;
      }

      id = R.id.movie_image;
      ImageView movieImage = ViewBindings.findChildViewById(rootView, id);
      if (movieImage == null) {
        break missingId;
      }

      id = R.id.movie_title;
      TextView movieTitle = ViewBindings.findChildViewById(rootView, id);
      if (movieTitle == null) {
        break missingId;
      }

      id = R.id.playButton;
      Button playButton = ViewBindings.findChildViewById(rootView, id);
      if (playButton == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = ViewBindings.findChildViewById(rootView, id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.shareMovie;
      ImageView shareMovie = ViewBindings.findChildViewById(rootView, id);
      if (shareMovie == null) {
        break missingId;
      }

      id = R.id.watchlist;
      ImageView watchlist = ViewBindings.findChildViewById(rootView, id);
      if (watchlist == null) {
        break missingId;
      }

      return new FragmentMovieDetailsBinding((ConstraintLayout) rootView, TextView3, backdropImage,
          btnTrailer, cardView, imageView, movieDescription, movieImage, movieTitle, playButton,
          progress, shareMovie, watchlist);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
