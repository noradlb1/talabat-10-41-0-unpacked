package com.talabat.feature.pickup.presentation.di;

import com.talabat.feature.pickup.presentation.PickupViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupViewModelFactory_Factory implements Factory<PickupViewModelFactory> {
    private final Provider<PickupViewModel> providerProvider;

    public PickupViewModelFactory_Factory(Provider<PickupViewModel> provider) {
        this.providerProvider = provider;
    }

    public static PickupViewModelFactory_Factory create(Provider<PickupViewModel> provider) {
        return new PickupViewModelFactory_Factory(provider);
    }

    public static PickupViewModelFactory newInstance(Provider<PickupViewModel> provider) {
        return new PickupViewModelFactory(provider);
    }

    public PickupViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
