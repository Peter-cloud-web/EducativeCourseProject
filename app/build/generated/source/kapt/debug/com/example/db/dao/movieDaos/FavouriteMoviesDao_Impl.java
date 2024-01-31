package com.example.db.dao.movieDaos;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.domain.entities.model.favourites.FavouriteMovies;
import java.lang.Class;
import java.lang.Exception;
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
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavouriteMoviesDao_Impl implements FavouriteMoviesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavouriteMovies> __insertionAdapterOfFavouriteMovies;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFavouriteMovie;

  public FavouriteMoviesDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavouriteMovies = new EntityInsertionAdapter<FavouriteMovies>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `favourite_movies` (`backdrop_path`,`overview`,`poster_path`,`id`,`title`,`vote_average`) VALUES (?,?,?,nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavouriteMovies entity) {
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
      }
    };
    this.__preparedStmtOfDeleteFavouriteMovie = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM favourite_movies WHERE  id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertFavouriteMovies(final FavouriteMovies movie,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFavouriteMovies.insert(movie);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFavouriteMovie(final int id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFavouriteMovie.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfDeleteFavouriteMovie.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FavouriteMovies>> getAllFavouriteMovies() {
    final String _sql = "SELECT * FROM favourite_movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"favourite_movies"}, new Callable<List<FavouriteMovies>>() {
      @Override
      @NonNull
      public List<FavouriteMovies> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
          final List<FavouriteMovies> _result = new ArrayList<FavouriteMovies>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FavouriteMovies _item;
            final String _tmpBackdrop_path;
            if (_cursor.isNull(_cursorIndexOfBackdropPath)) {
              _tmpBackdrop_path = null;
            } else {
              _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final String _tmpPoster_path;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPoster_path = null;
            } else {
              _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final float _tmpVote_average;
            _tmpVote_average = _cursor.getFloat(_cursorIndexOfVoteAverage);
            _item = new FavouriteMovies(_tmpBackdrop_path,_tmpOverview,_tmpPoster_path,_tmpId,_tmpTitle,_tmpVote_average);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
