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
import com.example.domain.converter.ListConverter;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults;
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
public final class TopRatedTvShowsDao_Impl implements TopRatedTvShowsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TvShowsResults> __insertionAdapterOfTvShowsResults;

  private final ListConverter __listConverter = new ListConverter();

  private final SharedSQLiteStatement __preparedStmtOfClearAllMovies;

  public TopRatedTvShowsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTvShowsResults = new EntityInsertionAdapter<TvShowsResults>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `toprated_movieshows` (`backdrop_path`,`first_air_date`,`genre_ids`,`id`,`name`,`origin_country`,`original_language`,`original_name`,`overview`,`popularity`,`poster_path`,`vote_average`,`vote_count`,`page`) VALUES (?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TvShowsResults entity) {
        if (entity.getBackdrop_path() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getBackdrop_path());
        }
        if (entity.getFirst_air_date() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getFirst_air_date());
        }
        final String _tmp = __listConverter.fromIntList(entity.getGenre_ids());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        statement.bindLong(4, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getName());
        }
        final String _tmp_1 = __listConverter.fromStringList(entity.getOrigin_country());
        if (_tmp_1 == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp_1);
        }
        if (entity.getOriginal_language() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getOriginal_language());
        }
        if (entity.getOriginal_name() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getOriginal_name());
        }
        if (entity.getOverview() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getOverview());
        }
        statement.bindDouble(10, entity.getPopularity());
        if (entity.getPoster_path() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getPoster_path());
        }
        statement.bindDouble(12, entity.getVote_average());
        statement.bindLong(13, entity.getVote_count());
        if (entity.getPage() == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, entity.getPage());
        }
      }
    };
    this.__preparedStmtOfClearAllMovies = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "Delete From toprated_movieshows";
        return _query;
      }
    };
  }

  @Override
  public Object insertsTopRatedTvShows(final List<TvShowsResults> topRatedTvShows,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTvShowsResults.insert(topRatedTvShows);
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
  public PagingSource<Integer, TvShowsResults> getTopRatedTvShows() {
    final String _sql = "SELECT * FROM toprated_movieshows Order By page";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<TvShowsResults>(_statement, __db, "toprated_movieshows") {
      @Override
      @NonNull
      protected List<TvShowsResults> convertRows(@NonNull final Cursor cursor) {
        final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(cursor, "backdrop_path");
        final int _cursorIndexOfFirstAirDate = CursorUtil.getColumnIndexOrThrow(cursor, "first_air_date");
        final int _cursorIndexOfGenreIds = CursorUtil.getColumnIndexOrThrow(cursor, "genre_ids");
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(cursor, "name");
        final int _cursorIndexOfOriginCountry = CursorUtil.getColumnIndexOrThrow(cursor, "origin_country");
        final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(cursor, "original_language");
        final int _cursorIndexOfOriginalName = CursorUtil.getColumnIndexOrThrow(cursor, "original_name");
        final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(cursor, "overview");
        final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(cursor, "popularity");
        final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(cursor, "poster_path");
        final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(cursor, "vote_average");
        final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(cursor, "vote_count");
        final int _cursorIndexOfPage = CursorUtil.getColumnIndexOrThrow(cursor, "page");
        final List<TvShowsResults> _result = new ArrayList<TvShowsResults>(cursor.getCount());
        while (cursor.moveToNext()) {
          final TvShowsResults _item;
          final String _tmpBackdrop_path;
          if (cursor.isNull(_cursorIndexOfBackdropPath)) {
            _tmpBackdrop_path = null;
          } else {
            _tmpBackdrop_path = cursor.getString(_cursorIndexOfBackdropPath);
          }
          final String _tmpFirst_air_date;
          if (cursor.isNull(_cursorIndexOfFirstAirDate)) {
            _tmpFirst_air_date = null;
          } else {
            _tmpFirst_air_date = cursor.getString(_cursorIndexOfFirstAirDate);
          }
          final List<Integer> _tmpGenre_ids;
          final String _tmp;
          if (cursor.isNull(_cursorIndexOfGenreIds)) {
            _tmp = null;
          } else {
            _tmp = cursor.getString(_cursorIndexOfGenreIds);
          }
          _tmpGenre_ids = __listConverter.toIntList(_tmp);
          final int _tmpId;
          _tmpId = cursor.getInt(_cursorIndexOfId);
          final String _tmpName;
          if (cursor.isNull(_cursorIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = cursor.getString(_cursorIndexOfName);
          }
          final List<String> _tmpOrigin_country;
          final String _tmp_1;
          if (cursor.isNull(_cursorIndexOfOriginCountry)) {
            _tmp_1 = null;
          } else {
            _tmp_1 = cursor.getString(_cursorIndexOfOriginCountry);
          }
          _tmpOrigin_country = __listConverter.toStringList(_tmp_1);
          final String _tmpOriginal_language;
          if (cursor.isNull(_cursorIndexOfOriginalLanguage)) {
            _tmpOriginal_language = null;
          } else {
            _tmpOriginal_language = cursor.getString(_cursorIndexOfOriginalLanguage);
          }
          final String _tmpOriginal_name;
          if (cursor.isNull(_cursorIndexOfOriginalName)) {
            _tmpOriginal_name = null;
          } else {
            _tmpOriginal_name = cursor.getString(_cursorIndexOfOriginalName);
          }
          final String _tmpOverview;
          if (cursor.isNull(_cursorIndexOfOverview)) {
            _tmpOverview = null;
          } else {
            _tmpOverview = cursor.getString(_cursorIndexOfOverview);
          }
          final double _tmpPopularity;
          _tmpPopularity = cursor.getDouble(_cursorIndexOfPopularity);
          final String _tmpPoster_path;
          if (cursor.isNull(_cursorIndexOfPosterPath)) {
            _tmpPoster_path = null;
          } else {
            _tmpPoster_path = cursor.getString(_cursorIndexOfPosterPath);
          }
          final double _tmpVote_average;
          _tmpVote_average = cursor.getDouble(_cursorIndexOfVoteAverage);
          final int _tmpVote_count;
          _tmpVote_count = cursor.getInt(_cursorIndexOfVoteCount);
          final Integer _tmpPage;
          if (cursor.isNull(_cursorIndexOfPage)) {
            _tmpPage = null;
          } else {
            _tmpPage = cursor.getInt(_cursorIndexOfPage);
          }
          _item = new TvShowsResults(_tmpBackdrop_path,_tmpFirst_air_date,_tmpGenre_ids,_tmpId,_tmpName,_tmpOrigin_country,_tmpOriginal_language,_tmpOriginal_name,_tmpOverview,_tmpPopularity,_tmpPoster_path,_tmpVote_average,_tmpVote_count,_tmpPage);
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
