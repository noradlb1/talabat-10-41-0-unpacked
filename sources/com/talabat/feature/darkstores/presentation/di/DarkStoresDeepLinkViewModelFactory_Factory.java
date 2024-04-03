package com.talabat.feature.darkstores.presentation.di;

import com.talabat.feature.darkstores.presentation.viewmodel.DarkStoresDeepLinkViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkStoresDeepLinkViewModelFactory_Factory implements Factory<DarkStoresDeepLinkViewModelFactory> {
    private final Provider<DarkStoresDeepLinkViewModel> providerProvider;

    public DarkStoresDeepLinkViewModelFactory_Factory(Provider<DarkStoresDeepLinkViewModel> provider) {
        this.providerProvider = provider;
    }

    public static DarkStoresDeepLinkViewModelFactory_Factory create(Provider<DarkStoresDeepLinkViewModel> provider) {
        return new DarkStoresDeepLinkViewModelFactory_Factory(provider);
    }

    public static DarkStoresDeepLinkViewModelFactory newInstance(Provider<DarkStoresDeepLinkViewModel> provider) {
        return new DarkStoresDeepLinkViewModelFactory(provider);
    }

    public DarkStoresDeepLinkViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
