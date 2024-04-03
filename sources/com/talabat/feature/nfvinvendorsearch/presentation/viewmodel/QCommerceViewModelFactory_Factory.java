package com.talabat.feature.nfvinvendorsearch.presentation.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class QCommerceViewModelFactory_Factory implements Factory<QCommerceViewModelFactory> {
    private final Provider<QCommerceViewModel> viewModelProvider;

    public QCommerceViewModelFactory_Factory(Provider<QCommerceViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static QCommerceViewModelFactory_Factory create(Provider<QCommerceViewModel> provider) {
        return new QCommerceViewModelFactory_Factory(provider);
    }

    public static QCommerceViewModelFactory newInstance(Provider<QCommerceViewModel> provider) {
        return new QCommerceViewModelFactory(provider);
    }

    public QCommerceViewModelFactory get() {
        return newInstance(this.viewModelProvider);
    }
}
