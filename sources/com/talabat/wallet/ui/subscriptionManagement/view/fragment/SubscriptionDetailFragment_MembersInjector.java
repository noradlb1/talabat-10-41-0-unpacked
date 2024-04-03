package com.talabat.wallet.ui.subscriptionManagement.view.fragment;

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
public final class SubscriptionDetailFragment_MembersInjector implements MembersInjector<SubscriptionDetailFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;
    private final Provider<GetSavingsInfoUseCase> getSavingsInfoUseCaseProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagProvider;

    public SubscriptionDetailFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<ISubscriptionsFeatureFlagsRepository> provider4, Provider<GetSavingsInfoUseCase> provider5) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.featureFlagRepoProvider = provider3;
        this.subscriptionsFeatureFlagProvider = provider4;
        this.getSavingsInfoUseCaseProvider = provider5;
    }

    public static MembersInjector<SubscriptionDetailFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<ISubscriptionsFeatureFlagsRepository> provider4, Provider<GetSavingsInfoUseCase> provider5) {
        return new SubscriptionDetailFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(SubscriptionDetailFragment subscriptionDetailFragment, ConfigurationLocalRepository configurationLocalRepository) {
        subscriptionDetailFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment.featureFlagRepo")
    public static void injectFeatureFlagRepo(SubscriptionDetailFragment subscriptionDetailFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        subscriptionDetailFragment.featureFlagRepo = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment.getSavingsInfoUseCase")
    public static void injectGetSavingsInfoUseCase(SubscriptionDetailFragment subscriptionDetailFragment, GetSavingsInfoUseCase getSavingsInfoUseCase) {
        subscriptionDetailFragment.getSavingsInfoUseCase = getSavingsInfoUseCase;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(SubscriptionDetailFragment subscriptionDetailFragment, LocationConfigurationRepository locationConfigurationRepository) {
        subscriptionDetailFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment.subscriptionsFeatureFlag")
    public static void injectSubscriptionsFeatureFlag(SubscriptionDetailFragment subscriptionDetailFragment, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        subscriptionDetailFragment.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
    }

    public void injectMembers(SubscriptionDetailFragment subscriptionDetailFragment) {
        injectConfigurationLocalRepository(subscriptionDetailFragment, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(subscriptionDetailFragment, this.locationConfigurationRepositoryProvider.get());
        injectFeatureFlagRepo(subscriptionDetailFragment, this.featureFlagRepoProvider.get());
        injectSubscriptionsFeatureFlag(subscriptionDetailFragment, this.subscriptionsFeatureFlagProvider.get());
        injectGetSavingsInfoUseCase(subscriptionDetailFragment, this.getSavingsInfoUseCaseProvider.get());
    }
}
