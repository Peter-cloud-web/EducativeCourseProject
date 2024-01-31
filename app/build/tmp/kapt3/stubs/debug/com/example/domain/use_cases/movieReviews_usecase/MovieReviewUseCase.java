package com.example.domain.use_cases.movieReviews_usecase;

import com.example.domain.repository.RemoteMoviesRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/domain/use_cases/movieReviews_usecase/MovieReviewUseCase;", "", "repository", "Lcom/example/domain/repository/RemoteMoviesRepository;", "(Lcom/example/domain/repository/RemoteMoviesRepository;)V", "invoke", "Lcom/example/domain/common/Resource;", "Lcom/example/cinemaxv3/models/responses/ReviewsResponse;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presentation_debug"})
public final class MovieReviewUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.repository.RemoteMoviesRepository repository = null;
    
    @javax.inject.Inject
    public MovieReviewUseCase(@org.jetbrains.annotations.NotNull
    com.example.domain.repository.RemoteMoviesRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.cinemaxv3.models.responses.ReviewsResponse>> $completion) {
        return null;
    }
}