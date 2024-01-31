package com.example.db.dao.remoteKeysDaos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.cinemaxv3.models.MovieRemoteKeys;
import com.example.cinemaxv3.models.TopRatedRemoteKeys;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u00f8\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001\u00a8\u0006\u0010\u00c0\u0006\u0001"}, d2 = {"Lcom/example/db/dao/remoteKeysDaos/TopRatedRemoteKeysDao;", "", "clearTopRatedRemoteKeys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopRatedCreationTime", "", "getTopRatedRemoteKeyByMovieID", "Lcom/example/cinemaxv3/models/TopRatedRemoteKeys;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAllTopRatedKeys", "topRatedRemoteKeys", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presentation_debug"})
@androidx.room.Dao
public abstract interface TopRatedRemoteKeysDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertAllTopRatedKeys(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.cinemaxv3.models.TopRatedRemoteKeys> topRatedRemoteKeys, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "Select * From toprated_remote_key Where movie_id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopRatedRemoteKeyByMovieID(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.cinemaxv3.models.TopRatedRemoteKeys> $completion);
    
    @androidx.room.Query(value = "Delete From toprated_remote_key")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearTopRatedRemoteKeys(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "Select created_at From toprated_remote_key Order By created_at DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopRatedCreationTime(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
}