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
public final class SubscriptionPlanFragment_MembersInjector implements MembersInjector<SubscriptionPlanFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;
    private final Provider<GetSavingsInfoUseCase> getSavingsInfoUseCaseProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagProvider;

    public SubscriptionPlanFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<GetSavingsInfoUseCase> provider4, Provider<ISubscriptionsFeatureFlagsRepository> provider5) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.featureFlagRepoProvider = provider3;
        this.getSavingsInfoUseCaseProvider = provider4;
        this.subscriptionsFeatureFlagProvider = provider5;
    }

    public static MembersInjector<SubscriptionPlanFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<GetSavingsInfoUseCase> provider4, Provider<ISubscriptionsFeatureFlagsRepository> provider5) {
        return new SubscriptionPlanFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionPlanFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(SubscriptionPlanFragment subscriptionPlanFragment, ConfigurationLocalRepository configurationLocalRepository) {
        subscriptionPlanFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionPlanFragment.featureFlagRepo")
    public static void injectFeatureFlagRepo(SubscriptionPlanFragment subscriptionPlanFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        subscriptionPlanFragment.featureFlagRepo = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionPlanFragment.getSavingsInfoUseCase")
    public static void injectGetSavingsInfoUseCase(SubscriptionPlanFragment subscriptionPlanFragment, GetSavingsInfoUseCase getSavingsInfoUseCase) {
        subscriptionPlanFragment.getSavingsInfoUseCase = getSavingsInfoUseCase;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionPlanFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(SubscriptionPlanFragment subscriptionPlanFragment, LocationConfigurationRepository locationConfigurationRepository) {
        subscriptionPlanFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionPlanFragment.subscriptionsFeatureFlag")
    public static void injectSubscriptionsFeatureFlag(SubscriptionPlanFragment subscriptionPlanFragment, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        subscriptionPlanFragment.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
    }

    public void injectMembers(SubscriptionPlanFragment subscriptionPlanFragment) {
        injectConfigurationLocalRepository(subscriptionPlanFragment, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(subscriptionPlanFragment, this.locationConfigurationRepositoryProvider.get());
        injectFeatureFlagRepo(subscriptionPlanFragment, this.featureFlagRepoProvider.get());
        injectGetSavingsInfoUseCase(subscriptionPlanFragment, this.getSavingsInfoUseCaseProvider.get());
        injectSubscriptionsFeatureFlag(subscriptionPlanFragment, this.subscriptionsFeatureFlagProvider.get());
    }
}
