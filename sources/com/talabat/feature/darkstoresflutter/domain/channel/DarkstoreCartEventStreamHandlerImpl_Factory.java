package com.talabat.feature.darkstoresflutter.domain.channel;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstoresflutter.domain.usecase.GetCartChanges;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoreCartEventStreamHandlerImpl_Factory implements Factory<DarkstoreCartEventStreamHandlerImpl> {
    private final Provider<GetCartChanges> getCartChangesProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;

    public DarkstoreCartEventStreamHandlerImpl_Factory(Provider<GetCartChanges> provider, Provider<RxSchedulersFactory> provider2) {
        this.getCartChangesProvider = provider;
        this.rxSchedulersFactoryProvider = provider2;
    }

    public static DarkstoreCartEventStreamHandlerImpl_Factory create(Provider<GetCartChanges> provider, Provider<RxSchedulersFactory> provider2) {
        return new DarkstoreCartEventStreamHandlerImpl_Factory(provider, provider2);
    }

    public static DarkstoreCartEventStreamHandlerImpl newInstance(GetCartChanges getCartChanges, RxSchedulersFactory rxSchedulersFactory) {
        return new DarkstoreCartEventStreamHandlerImpl(getCartChanges, rxSchedulersFactory);
    }

    public DarkstoreCartEventStreamHandlerImpl get() {
        return newInstance(this.getCartChangesProvider.get(), this.rxSchedulersFactoryProvider.get());
    }
}
