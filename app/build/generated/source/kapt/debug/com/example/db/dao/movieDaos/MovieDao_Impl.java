package com.example.db.dao.movieDaos;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.cinemaxv3.models.Movie;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Movie> __insertionAdapterOfMovie;

  private final SharedSQLiteStatement __preparedStmtOfClearAllMovies;

  public MovieDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovie = new EntityInsertionAdapter<Movie>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `movies` (`backdrop_path`,`overview`,`poster_path`,`id`,`title`,`vote_average`,`page`) VALUES (?,?,?,nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Movie entity) {
        if (entity.getBackdrop_path() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getBackdrop_path());
        }
        if (entity.getOverview() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getOverview());
        }
        if (entity.getPoster_path() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPoster_path());
        }
        statement.bindLong(4, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTitle());
        }
        statement.bindDouble(6, entity.getVote_average());
        if (entity.getPage() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getPage());
        }
      }
    };
    this.__preparedStmtOfClearAllMovies = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "Delete From movies";
        return _query;
      }
    };
  }

  @Override
  public Object insertPopularMovies(final List<Movie> movie,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMovie.insert(movie);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearAllMovies(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllMovies.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearAllMovies.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public PagingSource<Integer, Movie> getPopularMovies() {
    final String _sql = "SELECT * FROM movies Order By page";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<Movie>(_statement, __db, "movies") {
      @Override
      @NonNull
      protected List<Movie> convertRows(@NonNull final Cursor cursor) {
        final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(cursor, "backdrop_path");
        final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(cursor, "overview");
        final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(cursor, "poster_path");
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
        final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(cursor, "vote_average");
        final int _cursorIndexOfPage = CursorUtil.getColumnIndexOrThrow(cursor, "page");
        final List<Movie> _result = new ArrayList<Movie>(cursor.getCount());
        while (cursor.moveToNext()) {
          final Movie _item;
          final String _tmpBackdrop_path;
          if (cursor.isNull(_cursorIndexOfBackdropPath)) {
            _tmpBackdrop_path = null;
          } else {
            _tmpBackdrop_path = cursor.getString(_cursorIndexOfBackdropPath);
          }
          final String _tmpOverview;
          if (cursor.isNull(_cursorIndexOfOverview)) {
            _tmpOverview = null;
          } else {
            _tmpOverview = cursor.getString(_cursorIndexOfOverview);
          }
          final String _tmpPoster_path;
          if (cursor.isNull(_cursorIndexOfPosterPath)) {
            _tmpPoster_path = null;
          } else {
            _tmpPoster_path = cursor.getString(_cursorIndexOfPosterPath);
          }
          final int _tmpId;
          _tmpId = cursor.getInt(_cursorIndexOfId);
          final String _tmpTitle;
          if (cursor.isNull(_cursorIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = cursor.getString(_cursorIndexOfTitle);
          }
          final double _tmpVote_average;
          _tmpVote_average = cursor.getDouble(_cursorIndexOfVoteAverage);
          final Integer _tmpPage;
          if (cursor.isNull(_cursorIndexOfPage)) {
            _tmpPage = null;
          } else {
            _tmpPage = cursor.getInt(_cursorIndexOfPage);
          }
          _item = new Movie(_tmpBackdrop_path,_tmpOverview,_tmpPoster_path,_tmpId,_tmpTitle,_tmpVote_average,_tmpPage);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
