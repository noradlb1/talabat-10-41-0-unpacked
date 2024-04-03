package com.talabat.feature.darkstorescart.data.repository;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstorescart.data.local.CartDao;
import com.talabat.feature.darkstorescart.data.local.CartLocalDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresCartRepository_Factory implements Factory<DarkstoresCartRepository> {
    private final Provider<CartDao> cartDaoProvider;
    private final Provider<CartLocalDataSource> cartLocalDataSourceProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;

    public DarkstoresCartRepository_Factory(Provider<CartDao> provider, Provider<CartLocalDataSource> provider2, Provider<RxSchedulersFactory> provider3) {
        this.cartDaoProvider = provider;
        this.cartLocalDataSourceProvider = provider2;
        this.rxSchedulersFactoryProvider = provider3;
    }

    public static DarkstoresCartRepository_Factory create(Provider<CartDao> provider, Provider<CartLocalDataSource> provider2, Provider<RxSchedulersFactory> provider3) {
        return new DarkstoresCartRepository_Factory(provider, provider2, provider3);
    }

    public static DarkstoresCartRepository newInstance(CartDao cartDao, CartLocalDataSource cartLocalDataSource, RxSchedulersFactory rxSchedulersFactory) {
        return new DarkstoresCartRepository(cartDao, cartLocalDataSource, rxSchedulersFactory);
    }

    public DarkstoresCartRepository get() {
        return newInstance(this.cartDaoProvider.get(), this.cartLocalDataSourceProvider.get(), this.rxSchedulersFactoryProvider.get());
    }
}
