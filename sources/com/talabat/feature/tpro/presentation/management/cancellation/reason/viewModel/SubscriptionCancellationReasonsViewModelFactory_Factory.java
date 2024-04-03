package com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionCancellationReasonsViewModelFactory_Factory implements Factory<SubscriptionCancellationReasonsViewModelFactory> {
    private final Provider<SubscriptionCancellationReasonsViewModel> providerProvider;

    public SubscriptionCancellationReasonsViewModelFactory_Factory(Provider<SubscriptionCancellationReasonsViewModel> provider) {
        this.providerProvider = provider;
    }

    public static SubscriptionCancellationReasonsViewModelFactory_Factory create(Provider<SubscriptionCancellationReasonsViewModel> provider) {
        return new SubscriptionCancellationReasonsViewModelFactory_Factory(provider);
    }

    public static SubscriptionCancellationReasonsViewModelFactory newInstance(Provider<SubscriptionCancellationReasonsViewModel> provider) {
        return new SubscriptionCancellationReasonsViewModelFactory(provider);
    }

    public SubscriptionCancellationReasonsViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
