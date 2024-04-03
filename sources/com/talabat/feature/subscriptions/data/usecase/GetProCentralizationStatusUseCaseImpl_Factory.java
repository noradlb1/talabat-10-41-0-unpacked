package com.talabat.feature.subscriptions.data.usecase;

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
public final class GetProCentralizationStatusUseCaseImpl_Factory implements Factory<GetProCentralizationStatusUseCaseImpl> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;

    public GetProCentralizationStatusUseCaseImpl_Factory(Provider<ISubscriptionsRepository> provider, Provider<ISubscriptionStatusRepository> provider2) {
        this.repositoryProvider = provider;
        this.subscriptionStatusRepositoryProvider = provider2;
    }

    public static GetProCentralizationStatusUseCaseImpl_Factory create(Provider<ISubscriptionsRepository> provider, Provider<ISubscriptionStatusRepository> provider2) {
        return new GetProCentralizationStatusUseCaseImpl_Factory(provider, provider2);
    }

    public static GetProCentralizationStatusUseCaseImpl newInstance(ISubscriptionsRepository iSubscriptionsRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        return new GetProCentralizationStatusUseCaseImpl(iSubscriptionsRepository, iSubscriptionStatusRepository);
    }

    public GetProCentralizationStatusUseCaseImpl get() {
        return newInstance(this.repositoryProvider.get(), this.subscriptionStatusRepositoryProvider.get());
    }
}
