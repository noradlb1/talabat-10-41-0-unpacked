package com.talabat.feature.tpro.presentation.checkout;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class SubscriptionAtCheckoutBannerView_MembersInjector implements MembersInjector<SubscriptionAtCheckoutBannerView> {
    private final Provider<SubscriptionAtCheckoutBannerViewModelFactory> viewModelFactoryProvider;

    public SubscriptionAtCheckoutBannerView_MembersInjector(Provider<SubscriptionAtCheckoutBannerViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<SubscriptionAtCheckoutBannerView> create(Provider<SubscriptionAtCheckoutBannerViewModelFactory> provider) {
        return new SubscriptionAtCheckoutBannerView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView.viewModelFactory")
    public static void injectViewModelFactory(SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView, SubscriptionAtCheckoutBannerViewModelFactory subscriptionAtCheckoutBannerViewModelFactory) {
        subscriptionAtCheckoutBannerView.viewModelFactory = subscriptionAtCheckoutBannerViewModelFactory;
    }

    public void injectMembers(SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView) {
        injectViewModelFactory(subscriptionAtCheckoutBannerView, this.viewModelFactoryProvider.get());
    }
}
