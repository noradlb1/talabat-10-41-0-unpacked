package com.talabat.feature.rating.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.rating.domain.repo.RatingDataRepository;
import com.talabat.feature.rating.domain.repo.RatingSession;
import com.talabat.feature.rating.domain.repo.SubmitFeedBackRepository;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/rating/domain/RatingFeatureApi;", "Lcom/talabat/core/di/Api;", "ratingDataManager", "Lcom/talabat/feature/rating/domain/RatingDataManager;", "getRatingDataManager", "()Lcom/talabat/feature/rating/domain/RatingDataManager;", "ratingDataRepository", "Lcom/talabat/feature/rating/domain/repo/RatingDataRepository;", "getRatingDataRepository", "()Lcom/talabat/feature/rating/domain/repo/RatingDataRepository;", "ratingEventTracker", "Lcom/talabat/feature/rating/domain/EventTracker;", "getRatingEventTracker", "()Lcom/talabat/feature/rating/domain/EventTracker;", "ratingSession", "Lcom/talabat/feature/rating/domain/repo/RatingSession;", "getRatingSession", "()Lcom/talabat/feature/rating/domain/repo/RatingSession;", "shouldRateLastOrderUseCase", "Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "getShouldRateLastOrderUseCase", "()Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "submitFeedBackRepository", "Lcom/talabat/feature/rating/domain/repo/SubmitFeedBackRepository;", "getSubmitFeedBackRepository", "()Lcom/talabat/feature/rating/domain/repo/SubmitFeedBackRepository;", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RatingFeatureApi extends Api {
    @NotNull
    RatingDataManager getRatingDataManager();

    @NotNull
    RatingDataRepository getRatingDataRepository();

    @NotNull
    EventTracker getRatingEventTracker();

    @NotNull
    RatingSession getRatingSession();

    @NotNull
    ShouldRateLastOrderUseCase getShouldRateLastOrderUseCase();

    @NotNull
    SubmitFeedBackRepository getSubmitFeedBackRepository();
}
