package com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproUpgradeDetailsViewModelFactory_Factory implements Factory<TproUpgradeDetailsViewModelFactory> {
    private final Provider<TproUpgradeDetailsViewModel> providerProvider;

    public TproUpgradeDetailsViewModelFactory_Factory(Provider<TproUpgradeDetailsViewModel> provider) {
        this.providerProvider = provider;
    }

    public static TproUpgradeDetailsViewModelFactory_Factory create(Provider<TproUpgradeDetailsViewModel> provider) {
        return new TproUpgradeDetailsViewModelFactory_Factory(provider);
    }

    public static TproUpgradeDetailsViewModelFactory newInstance(Provider<TproUpgradeDetailsViewModel> provider) {
        return new TproUpgradeDetailsViewModelFactory(provider);
    }

    public TproUpgradeDetailsViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
