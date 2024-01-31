package com.example.db.dao.movieDaos;

import androidx.paging.PagingSource;
import androidx.room.*;
import com.example.cinemaxv3.models.Movie;
import com.example.db.dao.movieDaos.converters.ListConverter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\'J\u001f\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u00f8\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001\u00a8\u0006\r\u00c0\u0006\u0001"}, d2 = {"Lcom/example/db/dao/movieDaos/MovieDao;", "", "clearAllMovies", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPopularMovies", "Landroidx/paging/PagingSource;", "", "Lcom/example/cinemaxv3/models/Movie;", "insertPopularMovies", "movie", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presentation_debug"})
@androidx.room.Dao
@androidx.room.TypeConverters(value = {com.example.db.dao.movieDaos.converters.ListConverter.class})
public abstract interface MovieDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertPopularMovies(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.cinemaxv3.models.Movie> movie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM movies Order By page")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.example.cinemaxv3.models.Movie> getPopularMovies();
    
    @androidx.room.Query(value = "Delete From movies")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearAllMovies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}