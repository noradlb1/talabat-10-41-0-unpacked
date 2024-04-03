package com.talabat.feature.rating.domain.usecase;

import com.talabat.feature.rating.domain.model.GetPastOrdersRequestParamsProvider;
import com.talabat.feature.rating.domain.repo.GetPastOrdersRepository;
import com.talabat.feature.rating.domain.repo.RatingSession;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ShouldRateLastOrderUseCaseImpl_Factory implements Factory<ShouldRateLastOrderUseCaseImpl> {
    private final Provider<GetPastOrdersRepository> getPastOrdersRepositoryProvider;
    private final Provider<GetPastOrdersRequestParamsProvider> getPastOrdersRequestParamsProvider;
    private final Provider<RatingSession> ratingSessionProvider;

    public ShouldRateLastOrderUseCaseImpl_Factory(Provider<GetPastOrdersRepository> provider, Provider<RatingSession> provider2, Provider<GetPastOrdersRequestParamsProvider> provider3) {
        this.getPastOrdersRepositoryProvider = provider;
        this.ratingSessionProvider = provider2;
        this.getPastOrdersRequestParamsProvider = provider3;
    }

    public static ShouldRateLastOrderUseCaseImpl_Factory create(Provider<GetPastOrdersRepository> provider, Provider<RatingSession> provider2, Provider<GetPastOrdersRequestParamsProvider> provider3) {
        return new ShouldRateLastOrderUseCaseImpl_Factory(provider, provider2, provider3);
    }

    public static ShouldRateLastOrderUseCaseImpl newInstance(GetPastOrdersRepository getPastOrdersRepository, RatingSession ratingSession, GetPastOrdersRequestParamsProvider getPastOrdersRequestParamsProvider2) {
        return new ShouldRateLastOrderUseCaseImpl(getPastOrdersRepository, ratingSession, getPastOrdersRequestParamsProvider2);
    }

    public ShouldRateLastOrderUseCaseImpl get() {
        return newInstance(this.getPastOrdersRepositoryProvider.get(), this.ratingSessionProvider.get(), this.getPastOrdersRequestParamsProvider.get());
    }
}
