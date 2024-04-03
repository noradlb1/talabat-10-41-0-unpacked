package com.talabat.feature.rating.data.di;

import com.talabat.feature.rating.data.RatingDataManagerImpl;
import com.talabat.feature.rating.data.RatingDataRepositoryImpl;
import com.talabat.feature.rating.data.RatingEventTracker;
import com.talabat.feature.rating.data.RatingReasonMapperImpl;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.RatingReasonMapper;
import com.talabat.feature.rating.domain.repo.RatingDataRepository;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H'¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/rating/data/di/RatingFeatureModule;", "", "provide", "Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "impl", "Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCaseImpl;", "provideRateReasonMapper", "Lcom/talabat/feature/rating/domain/RatingReasonMapper;", "ratingReasonMapper", "Lcom/talabat/feature/rating/data/RatingReasonMapperImpl;", "provideRatingTracker", "Lcom/talabat/feature/rating/domain/EventTracker;", "Lcom/talabat/feature/rating/data/RatingEventTracker;", "provideReasonMapper", "Lcom/talabat/feature/rating/domain/RatingDataManager;", "Lcom/talabat/feature/rating/data/RatingDataManagerImpl;", "ratingDataRepository", "Lcom/talabat/feature/rating/domain/repo/RatingDataRepository;", "Lcom/talabat/feature/rating/data/RatingDataRepositoryImpl;", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {RatingNetworkModule.class, RatingUserDataModule.class})
public interface RatingFeatureModule {
    @NotNull
    @Binds
    @Reusable
    ShouldRateLastOrderUseCase provide(@NotNull ShouldRateLastOrderUseCaseImpl shouldRateLastOrderUseCaseImpl);

    @NotNull
    @Binds
    @Reusable
    RatingReasonMapper provideRateReasonMapper(@NotNull RatingReasonMapperImpl ratingReasonMapperImpl);

    @NotNull
    @Binds
    @Reusable
    EventTracker provideRatingTracker(@NotNull RatingEventTracker ratingEventTracker);

    @NotNull
    @Binds
    @Reusable
    RatingDataManager provideReasonMapper(@NotNull RatingDataManagerImpl ratingDataManagerImpl);

    @NotNull
    @Binds
    @Reusable
    RatingDataRepository ratingDataRepository(@NotNull RatingDataRepositoryImpl ratingDataRepositoryImpl);
}
