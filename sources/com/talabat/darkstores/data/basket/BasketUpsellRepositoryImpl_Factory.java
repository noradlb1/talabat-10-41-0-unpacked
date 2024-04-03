package com.talabat.darkstores.data.basket;

import com.talabat.darkstores.data.basket.local.BasketUpsellLocalDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BasketUpsellRepositoryImpl_Factory implements Factory<BasketUpsellRepositoryImpl> {
    private final Provider<BasketUpsellLocalDataSource> basketUpsellLocalDataSourceProvider;

    public BasketUpsellRepositoryImpl_Factory(Provider<BasketUpsellLocalDataSource> provider) {
        this.basketUpsellLocalDataSourceProvider = provider;
    }

    public static BasketUpsellRepositoryImpl_Factory create(Provider<BasketUpsellLocalDataSource> provider) {
        return new BasketUpsellRepositoryImpl_Factory(provider);
    }

    public static BasketUpsellRepositoryImpl newInstance(BasketUpsellLocalDataSource basketUpsellLocalDataSource) {
        return new BasketUpsellRepositoryImpl(basketUpsellLocalDataSource);
    }

    public BasketUpsellRepositoryImpl get() {
        return newInstance(this.basketUpsellLocalDataSourceProvider.get());
    }
}
