package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
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
public final class GetActiveSubscriptionsUseCase_Factory implements Factory<GetActiveSubscriptionsUseCase> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ISubscriptionsRepository> repositoryProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;

    public GetActiveSubscriptionsUseCase_Factory(Provider<ISubscriptionsRepository> provider, Provider<ConfigurationLocalRepository> provider2, Provider<ISubscriptionStatusRepository> provider3) {
        this.repositoryProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.subscriptionStatusRepositoryProvider = provider3;
    }

    public static GetActiveSubscriptionsUseCase_Factory create(Provider<ISubscriptionsRepository> provider, Provider<ConfigurationLocalRepository> provider2, Provider<ISubscriptionStatusRepository> provider3) {
        return new GetActiveSubscriptionsUseCase_Factory(provider, provider2, provider3);
    }

    public static GetActiveSubscriptionsUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository, ConfigurationLocalRepository configurationLocalRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        return new GetActiveSubscriptionsUseCase(iSubscriptionsRepository, configurationLocalRepository, iSubscriptionStatusRepository);
    }

    public GetActiveSubscriptionsUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.configurationLocalRepositoryProvider.get(), this.subscriptionStatusRepositoryProvider.get());
    }
}
