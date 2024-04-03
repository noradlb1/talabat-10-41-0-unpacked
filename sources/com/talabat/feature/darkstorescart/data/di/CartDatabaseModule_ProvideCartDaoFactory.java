package com.talabat.feature.darkstorescart.data.di;

import com.talabat.feature.darkstorescart.data.local.CartDao;
import com.talabat.feature.darkstorescart.data.local.CartDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartDatabaseModule_ProvideCartDaoFactory implements Factory<CartDao> {
    private final Provider<CartDatabase> cartDatabaseProvider;

    public CartDatabaseModule_ProvideCartDaoFactory(Provider<CartDatabase> provider) {
        this.cartDatabaseProvider = provider;
    }

    public static CartDatabaseModule_ProvideCartDaoFactory create(Provider<CartDatabase> provider) {
        return new CartDatabaseModule_ProvideCartDaoFactory(provider);
    }

    public static CartDao provideCartDao(CartDatabase cartDatabase) {
        return (CartDao) Preconditions.checkNotNullFromProvides(CartDatabaseModule.INSTANCE.provideCartDao(cartDatabase));
    }

    public CartDao get() {
        return provideCartDao(this.cartDatabaseProvider.get());
    }
}
