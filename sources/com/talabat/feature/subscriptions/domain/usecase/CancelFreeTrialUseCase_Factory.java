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
public final class CancelFreeTrialUseCase_Factory implements Factory<CancelFreeTrialUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public CancelFreeTrialUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static CancelFreeTrialUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new CancelFreeTrialUseCase_Factory(provider);
    }

    public static CancelFreeTrialUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new CancelFreeTrialUseCase(iSubscriptionsRepository);
    }

    public CancelFreeTrialUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
