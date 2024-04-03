package com.talabat.feature.tpro.presentation.checkout;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionAtCheckoutBannerViewModelFactory_Factory implements Factory<SubscriptionAtCheckoutBannerViewModelFactory> {
    private final Provider<SubscriptionAtCheckoutBannerViewModel> providerProvider;

    public SubscriptionAtCheckoutBannerViewModelFactory_Factory(Provider<SubscriptionAtCheckoutBannerViewModel> provider) {
        this.providerProvider = provider;
    }

    public static SubscriptionAtCheckoutBannerViewModelFactory_Factory create(Provider<SubscriptionAtCheckoutBannerViewModel> provider) {
        return new SubscriptionAtCheckoutBannerViewModelFactory_Factory(provider);
    }

    public static SubscriptionAtCheckoutBannerViewModelFactory newInstance(Provider<SubscriptionAtCheckoutBannerViewModel> provider) {
        return new SubscriptionAtCheckoutBannerViewModelFactory(provider);
    }

    public SubscriptionAtCheckoutBannerViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
