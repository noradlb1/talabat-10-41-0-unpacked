package com.talabat.flutter.groceryhome.data.repository;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import service.ApiHandler;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GroceryHomeVendorRepositoryImpl_Factory implements Factory<GroceryHomeVendorRepositoryImpl> {
    private final Provider<ApiHandler> apiHandlerProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;

    public GroceryHomeVendorRepositoryImpl_Factory(Provider<ApiHandler> provider, Provider<RxSchedulersFactory> provider2) {
        this.apiHandlerProvider = provider;
        this.rxSchedulersFactoryProvider = provider2;
    }

    public static GroceryHomeVendorRepositoryImpl_Factory create(Provider<ApiHandler> provider, Provider<RxSchedulersFactory> provider2) {
        return new GroceryHomeVendorRepositoryImpl_Factory(provider, provider2);
    }

    public static GroceryHomeVendorRepositoryImpl newInstance(ApiHandler apiHandler, RxSchedulersFactory rxSchedulersFactory) {
        return new GroceryHomeVendorRepositoryImpl(apiHandler, rxSchedulersFactory);
    }

    public GroceryHomeVendorRepositoryImpl get() {
        return newInstance(this.apiHandlerProvider.get(), this.rxSchedulersFactoryProvider.get());
    }
}
