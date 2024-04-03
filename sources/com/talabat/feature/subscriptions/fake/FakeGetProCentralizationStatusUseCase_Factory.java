package com.talabat.feature.subscriptions.fake;

import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FakeGetProCentralizationStatusUseCase_Factory implements Factory<FakeGetProCentralizationStatusUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;

    public FakeGetProCentralizationStatusUseCase_Factory(Provider<ISubscriptionsRepository> provider, Provider<ISubscriptionStatusRepository> provider2) {
        this.repositoryProvider = provider;
        this.subscriptionStatusRepositoryProvider = provider2;
    }

    public static FakeGetProCentralizationStatusUseCase_Factory create(Provider<ISubscriptionsRepository> provider, Provider<ISubscriptionStatusRepository> provider2) {
        return new FakeGetProCentralizationStatusUseCase_Factory(provider, provider2);
    }

    public static FakeGetProCentralizationStatusUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        return new FakeGetProCentralizationStatusUseCase(iSubscriptionsRepository, iSubscriptionStatusRepository);
    }

    public FakeGetProCentralizationStatusUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.subscriptionStatusRepositoryProvider.get());
    }
}
