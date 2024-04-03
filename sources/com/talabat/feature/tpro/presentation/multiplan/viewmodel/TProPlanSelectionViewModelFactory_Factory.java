package com.talabat.feature.tpro.presentation.multiplan.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProPlanSelectionViewModelFactory_Factory implements Factory<TProPlanSelectionViewModelFactory> {
    private final Provider<TProPlanSelectionViewModel> providerProvider;

    public TProPlanSelectionViewModelFactory_Factory(Provider<TProPlanSelectionViewModel> provider) {
        this.providerProvider = provider;
    }

    public static TProPlanSelectionViewModelFactory_Factory create(Provider<TProPlanSelectionViewModel> provider) {
        return new TProPlanSelectionViewModelFactory_Factory(provider);
    }

    public static TProPlanSelectionViewModelFactory newInstance(Provider<TProPlanSelectionViewModel> provider) {
        return new TProPlanSelectionViewModelFactory(provider);
    }

    public TProPlanSelectionViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
