package com.talabat.feature.activecarts.presentation.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BasketListViewModelFactory_Factory implements Factory<BasketListViewModelFactory> {
    private final Provider<BasketListViewModel> viewModelProvider;

    public BasketListViewModelFactory_Factory(Provider<BasketListViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static BasketListViewModelFactory_Factory create(Provider<BasketListViewModel> provider) {
        return new BasketListViewModelFactory_Factory(provider);
    }

    public static BasketListViewModelFactory newInstance(Provider<BasketListViewModel> provider) {
        return new BasketListViewModelFactory(provider);
    }

    public BasketListViewModelFactory get() {
        return newInstance(this.viewModelProvider);
    }
}
