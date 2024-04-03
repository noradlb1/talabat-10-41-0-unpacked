package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetSubscriptionsUseCase_Factory implements Factory<GetSubscriptionsUseCase> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public GetSubscriptionsUseCase_Factory(Provider<ISubscriptionsRepository> provider, Provider<ConfigurationLocalRepository> provider2) {
        this.repositoryProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
    }

    public static GetSubscriptionsUseCase_Factory create(Provider<ISubscriptionsRepository> provider, Provider<ConfigurationLocalRepository> provider2) {
        return new GetSubscriptionsUseCase_Factory(provider, provider2);
    }

    public static GetSubscriptionsUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository, ConfigurationLocalRepository configurationLocalRepository) {
        return new GetSubscriptionsUseCase(iSubscriptionsRepository, configurationLocalRepository);
    }

    public GetSubscriptionsUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.configurationLocalRepositoryProvider.get());
    }
}
