package com.talabat.feature.darkstoresflutter.domain.channel;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstoresflutter.domain.usecase.AddItemToCartUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.ClearCartUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.RefreshCartUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.RemoveItemFromCartUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresCartMethodCallHandlerImpl_Factory implements Factory<DarkstoresCartMethodCallHandlerImpl> {
    private final Provider<AddItemToCartUseCase> addItemToCartProvider;
    private final Provider<ClearCartUseCase> clearCartProvider;
    private final Provider<RefreshCartUseCase> refreshCartProvider;
    private final Provider<RemoveItemFromCartUseCase> removeFromCartProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;

    public DarkstoresCartMethodCallHandlerImpl_Factory(Provider<AddItemToCartUseCase> provider, Provider<RemoveItemFromCartUseCase> provider2, Provider<ClearCartUseCase> provider3, Provider<RefreshCartUseCase> provider4, Provider<RxSchedulersFactory> provider5) {
        this.addItemToCartProvider = provider;
        this.removeFromCartProvider = provider2;
        this.clearCartProvider = provider3;
        this.refreshCartProvider = provider4;
        this.rxSchedulersFactoryProvider = provider5;
    }

    public static DarkstoresCartMethodCallHandlerImpl_Factory create(Provider<AddItemToCartUseCase> provider, Provider<RemoveItemFromCartUseCase> provider2, Provider<ClearCartUseCase> provider3, Provider<RefreshCartUseCase> provider4, Provider<RxSchedulersFactory> provider5) {
        return new DarkstoresCartMethodCallHandlerImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DarkstoresCartMethodCallHandlerImpl newInstance(AddItemToCartUseCase addItemToCartUseCase, RemoveItemFromCartUseCase removeItemFromCartUseCase, ClearCartUseCase clearCartUseCase, RefreshCartUseCase refreshCartUseCase, RxSchedulersFactory rxSchedulersFactory) {
        return new DarkstoresCartMethodCallHandlerImpl(addItemToCartUseCase, removeItemFromCartUseCase, clearCartUseCase, refreshCartUseCase, rxSchedulersFactory);
    }

    public DarkstoresCartMethodCallHandlerImpl get() {
        return newInstance(this.addItemToCartProvider.get(), this.removeFromCartProvider.get(), this.clearCartProvider.get(), this.refreshCartProvider.get(), this.rxSchedulersFactoryProvider.get());
    }
}
