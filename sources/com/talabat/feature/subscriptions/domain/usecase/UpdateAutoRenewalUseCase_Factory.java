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
public final class UpdateAutoRenewalUseCase_Factory implements Factory<UpdateAutoRenewalUseCase> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<GetSubscriptionsUseCase> getSubscriptionsUseCaseProvider;
    private final Provider<ISubscriptionsRepository> repositoryProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionsStatusRepositoryProvider;

    public UpdateAutoRenewalUseCase_Factory(Provider<ISubscriptionsRepository> provider, Provider<ISubscriptionStatusRepository> provider2, Provider<GetSubscriptionsUseCase> provider3, Provider<ConfigurationLocalRepository> provider4) {
        this.repositoryProvider = provider;
        this.subscriptionsStatusRepositoryProvider = provider2;
        this.getSubscriptionsUseCaseProvider = provider3;
        this.configurationLocalRepositoryProvider = provider4;
    }

    public static UpdateAutoRenewalUseCase_Factory create(Provider<ISubscriptionsRepository> provider, Provider<ISubscriptionStatusRepository> provider2, Provider<GetSubscriptionsUseCase> provider3, Provider<ConfigurationLocalRepository> provider4) {
        return new UpdateAutoRenewalUseCase_Factory(provider, provider2, provider3, provider4);
    }

    public static UpdateAutoRenewalUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository, GetSubscriptionsUseCase getSubscriptionsUseCase, ConfigurationLocalRepository configurationLocalRepository) {
        return new UpdateAutoRenewalUseCase(iSubscriptionsRepository, iSubscriptionStatusRepository, getSubscriptionsUseCase, configurationLocalRepository);
    }

    public UpdateAutoRenewalUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.subscriptionsStatusRepositoryProvider.get(), this.getSubscriptionsUseCaseProvider.get(), this.configurationLocalRepositoryProvider.get());
    }
}
