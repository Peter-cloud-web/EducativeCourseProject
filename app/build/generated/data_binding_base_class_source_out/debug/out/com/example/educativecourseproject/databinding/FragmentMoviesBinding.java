// Generated by view binder compiler. Do not edit!
package com.example.educativecourseproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.educativecourseproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMoviesBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnTrailer;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final TextView internetConnection;

  @NonNull
  public final ImageView popMov;

  @NonNull
  public final RecyclerView popularMoviesRecyclerview;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final RecyclerView topRatedMoviesRecyclerview;

  @NonNull
  public final RecyclerView upComingMoviesRecyclerview;

  @NonNull
  public final TextView vote;

  private FragmentMoviesBinding(@NonNull ScrollView rootView, @NonNull Button btnTrailer,
      @NonNull CardView cardView, @NonNull TextView internetConnection, @NonNull ImageView popMov,
      @NonNull RecyclerView popularMoviesRecyclerview, @NonNull TextView textView2,
      @NonNull TextView textView3, @NonNull TextView textView4,
      @NonNull RecyclerView topRatedMoviesRecyclerview,
      @NonNull RecyclerView upComingMoviesRecyclerview, @NonNull TextView vote) {
    this.rootView = rootView;
    this.btnTrailer = btnTrailer;
    this.cardView = cardView;
    this.internetConnection = internetConnection;
    this.popMov = popMov;
    this.popularMoviesRecyclerview = popularMoviesRecyclerview;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.topRatedMoviesRecyclerview = topRatedMoviesRecyclerview;
    this.upComingMoviesRecyclerview = upComingMoviesRecyclerview;
    this.vote = vote;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMoviesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMoviesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_movies, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMoviesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
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

      id = R.id.internet_connection;
      TextView internetConnection = ViewBindings.findChildViewById(rootView, id);
      if (internetConnection == null) {
        break missingId;
      }

      id = R.id.popMov;
      ImageView popMov = ViewBindings.findChildViewById(rootView, id);
      if (popMov == null) {
        break missingId;
      }

      id = R.id.popular_movies_recyclerview;
      RecyclerView popularMoviesRecyclerview = ViewBindings.findChildViewById(rootView, id);
      if (popularMoviesRecyclerview == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.topRated_movies_recyclerview;
      RecyclerView topRatedMoviesRecyclerview = ViewBindings.findChildViewById(rootView, id);
      if (topRatedMoviesRecyclerview == null) {
        break missingId;
      }

      id = R.id.upComing_movies_recyclerview;
      RecyclerView upComingMoviesRecyclerview = ViewBindings.findChildViewById(rootView, id);
      if (upComingMoviesRecyclerview == null) {
        break missingId;
      }

      id = R.id.vote;
      TextView vote = ViewBindings.findChildViewById(rootView, id);
      if (vote == null) {
        break missingId;
      }

      return new FragmentMoviesBinding((ScrollView) rootView, btnTrailer, cardView,
          internetConnection, popMov, popularMoviesRecyclerview, textView2, textView3, textView4,
          topRatedMoviesRecyclerview, upComingMoviesRecyclerview, vote);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
