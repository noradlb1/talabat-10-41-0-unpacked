package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProOnBoardingBannerAndPlansUseCase_Factory implements Factory<TProOnBoardingBannerAndPlansUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public TProOnBoardingBannerAndPlansUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static TProOnBoardingBannerAndPlansUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new TProOnBoardingBannerAndPlansUseCase_Factory(provider);
    }

    public static TProOnBoardingBannerAndPlansUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new TProOnBoardingBannerAndPlansUseCase(iSubscriptionsRepository);
    }

    public TProOnBoardingBannerAndPlansUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
