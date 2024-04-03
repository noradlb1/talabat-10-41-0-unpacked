package com.talabat.feature.activecarts.data.repository;

import buisnessmodels.Cart;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ActiveCartInfoRepositoryImpl_Factory implements Factory<ActiveCartInfoRepositoryImpl> {
    private final Provider<Cart> cartProvider;
    private final Provider<DarkstoresCartListRepository> darkstoresCartListRepositoryProvider;
    private final Provider<DarkstoresRepository> darkstoresRepositoryProvider;

    public ActiveCartInfoRepositoryImpl_Factory(Provider<Cart> provider, Provider<DarkstoresRepository> provider2, Provider<DarkstoresCartListRepository> provider3) {
        this.cartProvider = provider;
        this.darkstoresRepositoryProvider = provider2;
        this.darkstoresCartListRepositoryProvider = provider3;
    }

    public static ActiveCartInfoRepositoryImpl_Factory create(Provider<Cart> provider, Provider<DarkstoresRepository> provider2, Provider<DarkstoresCartListRepository> provider3) {
        return new ActiveCartInfoRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static ActiveCartInfoRepositoryImpl newInstance(Cart cart, DarkstoresRepository darkstoresRepository, DarkstoresCartListRepository darkstoresCartListRepository) {
        return new ActiveCartInfoRepositoryImpl(cart, darkstoresRepository, darkstoresCartListRepository);
    }

    public ActiveCartInfoRepositoryImpl get() {
        return newInstance(this.cartProvider.get(), this.darkstoresRepositoryProvider.get(), this.darkstoresCartListRepositoryProvider.get());
    }
}
