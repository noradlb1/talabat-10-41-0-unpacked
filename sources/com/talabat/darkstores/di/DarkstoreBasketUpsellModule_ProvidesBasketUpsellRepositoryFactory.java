package com.talabat.darkstores.di;

import com.talabat.darkstores.data.basket.BasketUpsellRepositoryImpl;
import com.talabat.darkstores.domain.basket.BasketUpsellRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoreBasketUpsellModule_ProvidesBasketUpsellRepositoryFactory implements Factory<BasketUpsellRepository> {
    private final Provider<BasketUpsellRepositoryImpl> implProvider;

    public DarkstoreBasketUpsellModule_ProvidesBasketUpsellRepositoryFactory(Provider<BasketUpsellRepositoryImpl> provider) {
        this.implProvider = provider;
    }

    public static DarkstoreBasketUpsellModule_ProvidesBasketUpsellRepositoryFactory create(Provider<BasketUpsellRepositoryImpl> provider) {
        return new DarkstoreBasketUpsellModule_ProvidesBasketUpsellRepositoryFactory(provider);
    }

    public static BasketUpsellRepository providesBasketUpsellRepository(BasketUpsellRepositoryImpl basketUpsellRepositoryImpl) {
        return (BasketUpsellRepository) Preconditions.checkNotNullFromProvides(DarkstoreBasketUpsellModule.INSTANCE.providesBasketUpsellRepository(basketUpsellRepositoryImpl));
    }

    public BasketUpsellRepository get() {
        return providesBasketUpsellRepository(this.implProvider.get());
    }
}
