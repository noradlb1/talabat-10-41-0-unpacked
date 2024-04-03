package com.talabat.feature.tpro.presentation.management.details.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproSubscriptionDetailsViewModelFactory_Factory implements Factory<TproSubscriptionDetailsViewModelFactory> {
    private final Provider<TproSubscriptionDetailsViewModel> providerProvider;

    public TproSubscriptionDetailsViewModelFactory_Factory(Provider<TproSubscriptionDetailsViewModel> provider) {
        this.providerProvider = provider;
    }

    public static TproSubscriptionDetailsViewModelFactory_Factory create(Provider<TproSubscriptionDetailsViewModel> provider) {
        return new TproSubscriptionDetailsViewModelFactory_Factory(provider);
    }

    public static TproSubscriptionDetailsViewModelFactory newInstance(Provider<TproSubscriptionDetailsViewModel> provider) {
        return new TproSubscriptionDetailsViewModelFactory(provider);
    }

    public TproSubscriptionDetailsViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
