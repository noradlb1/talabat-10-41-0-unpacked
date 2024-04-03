package com.talabat.feature.tpro.presentation.checkout;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.MultiPlanParams;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionAtCheckoutBannerViewModel_Factory implements Factory<SubscriptionAtCheckoutBannerViewModel> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<MultiPlanParams> multiPlanParamsProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<ISubscriptionsTracker> subscriptionsTrackerProvider;

    public SubscriptionAtCheckoutBannerViewModel_Factory(Provider<MultiPlanParams> provider, Provider<ConfigurationLocalRepository> provider2, Provider<ISubscriptionStatusRepository> provider3, Provider<ISubscriptionsTracker> provider4) {
        this.multiPlanParamsProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.subscriptionStatusRepositoryProvider = provider3;
        this.subscriptionsTrackerProvider = provider4;
    }

    public static SubscriptionAtCheckoutBannerViewModel_Factory create(Provider<MultiPlanParams> provider, Provider<ConfigurationLocalRepository> provider2, Provider<ISubscriptionStatusRepository> provider3, Provider<ISubscriptionsTracker> provider4) {
        return new SubscriptionAtCheckoutBannerViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static SubscriptionAtCheckoutBannerViewModel newInstance(MultiPlanParams multiPlanParams, ConfigurationLocalRepository configurationLocalRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository, ISubscriptionsTracker iSubscriptionsTracker) {
        return new SubscriptionAtCheckoutBannerViewModel(multiPlanParams, configurationLocalRepository, iSubscriptionStatusRepository, iSubscriptionsTracker);
    }

    public SubscriptionAtCheckoutBannerViewModel get() {
        return newInstance(this.multiPlanParamsProvider.get(), this.configurationLocalRepositoryProvider.get(), this.subscriptionStatusRepositoryProvider.get(), this.subscriptionsTrackerProvider.get());
    }
}
