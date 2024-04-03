package com.talabat.wallet.ui.subscriptionManagement.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class SubscriptionManagementFragment_MembersInjector implements MembersInjector<SubscriptionManagementFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;
    private final Provider<GetSavingsInfoUseCase> getSavingsInfoUseCaseProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagProvider;

    public SubscriptionManagementFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<GetSavingsInfoUseCase> provider4, Provider<ISubscriptionsFeatureFlagsRepository> provider5) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.featureFlagRepoProvider = provider3;
        this.getSavingsInfoUseCaseProvider = provider4;
        this.subscriptionsFeatureFlagProvider = provider5;
    }

    public static MembersInjector<SubscriptionManagementFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<GetSavingsInfoUseCase> provider4, Provider<ISubscriptionsFeatureFlagsRepository> provider5) {
        return new SubscriptionManagementFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(SubscriptionManagementFragment subscriptionManagementFragment, ConfigurationLocalRepository configurationLocalRepository) {
        subscriptionManagementFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment.featureFlagRepo")
    public static void injectFeatureFlagRepo(SubscriptionManagementFragment subscriptionManagementFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        subscriptionManagementFragment.featureFlagRepo = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment.getSavingsInfoUseCase")
    public static void injectGetSavingsInfoUseCase(SubscriptionManagementFragment subscriptionManagementFragment, GetSavingsInfoUseCase getSavingsInfoUseCase) {
        subscriptionManagementFragment.getSavingsInfoUseCase = getSavingsInfoUseCase;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(SubscriptionManagementFragment subscriptionManagementFragment, LocationConfigurationRepository locationConfigurationRepository) {
        subscriptionManagementFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment.subscriptionsFeatureFlag")
    public static void injectSubscriptionsFeatureFlag(SubscriptionManagementFragment subscriptionManagementFragment, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        subscriptionManagementFragment.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
    }

    public void injectMembers(SubscriptionManagementFragment subscriptionManagementFragment) {
        injectConfigurationLocalRepository(subscriptionManagementFragment, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(subscriptionManagementFragment, this.locationConfigurationRepositoryProvider.get());
        injectFeatureFlagRepo(subscriptionManagementFragment, this.featureFlagRepoProvider.get());
        injectGetSavingsInfoUseCase(subscriptionManagementFragment, this.getSavingsInfoUseCaseProvider.get());
        injectSubscriptionsFeatureFlag(subscriptionManagementFragment, this.subscriptionsFeatureFlagProvider.get());
    }
}
