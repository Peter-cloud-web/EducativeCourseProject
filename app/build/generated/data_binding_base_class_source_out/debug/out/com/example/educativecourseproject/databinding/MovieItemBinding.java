// Generated by view binder compiler. Do not edit!
package com.example.educativecourseproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.educativecourseproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MovieItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView Rating;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final ImageView imageMovies;

  private MovieItemBinding(@NonNull CardView rootView, @NonNull TextView Rating,
      @NonNull CardView cardView, @NonNull ImageView imageMovies) {
    this.rootView = rootView;
    this.Rating = Rating;
    this.cardView = cardView;
    this.imageMovies = imageMovies;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static MovieItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MovieItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.movie_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MovieItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Rating;
      TextView Rating = ViewBindings.findChildViewById(rootView, id);
      if (Rating == null) {
        break missingId;
      }

      CardView cardView = (CardView) rootView;

      id = R.id.image_movies;
      ImageView imageMovies = ViewBindings.findChildViewById(rootView, id);
      if (imageMovies == null) {
        break missingId;
      }

      return new MovieItemBinding((CardView) rootView, Rating, cardView, imageMovies);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
