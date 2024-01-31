package com.example.domain.pager;

import androidx.paging.PagingData;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2 = {"Lcom/example/domain/pager/TvShowsAiringTodayPager;", "", "getTvSowsAiringToday", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "presentation_debug"})
public abstract interface TvShowsAiringTodayPager {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.domain.entities.model.tvShowsResponse.TvShowsResults>> getTvSowsAiringToday();
}