package com.talabat.feature.rating.data;

import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.RatingReasonMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingDataRepositoryImpl_Factory implements Factory<RatingDataRepositoryImpl> {
    private final Provider<RatingDataManager> ratingDataManagerProvider;
    private final Provider<RatingReasonMapper> ratingReasonMapperProvider;

    public RatingDataRepositoryImpl_Factory(Provider<RatingReasonMapper> provider, Provider<RatingDataManager> provider2) {
        this.ratingReasonMapperProvider = provider;
        this.ratingDataManagerProvider = provider2;
    }

    public static RatingDataRepositoryImpl_Factory create(Provider<RatingReasonMapper> provider, Provider<RatingDataManager> provider2) {
        return new RatingDataRepositoryImpl_Factory(provider, provider2);
    }

    public static RatingDataRepositoryImpl newInstance(RatingReasonMapper ratingReasonMapper, RatingDataManager ratingDataManager) {
        return new RatingDataRepositoryImpl(ratingReasonMapper, ratingDataManager);
    }

    public RatingDataRepositoryImpl get() {
        return newInstance(this.ratingReasonMapperProvider.get(), this.ratingDataManagerProvider.get());
    }
}
