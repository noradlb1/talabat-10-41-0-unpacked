package com.talabat.feature.darkstorescartlist.data.di;

import com.talabat.feature.darkstorescartlist.data.repository.DarkstoresCartListRepositoryImpl;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CartListDataModule_ProvideCartListRepositoryFactory implements Factory<DarkstoresCartListRepository> {
    private final Provider<DarkstoresCartListRepositoryImpl> cartListRepositoryImplProvider;
    private final CartListDataModule module;

    public CartListDataModule_ProvideCartListRepositoryFactory(CartListDataModule cartListDataModule, Provider<DarkstoresCartListRepositoryImpl> provider) {
        this.module = cartListDataModule;
        this.cartListRepositoryImplProvider = provider;
    }

    public static CartListDataModule_ProvideCartListRepositoryFactory create(CartListDataModule cartListDataModule, Provider<DarkstoresCartListRepositoryImpl> provider) {
        return new CartListDataModule_ProvideCartListRepositoryFactory(cartListDataModule, provider);
    }

    public static DarkstoresCartListRepository provideCartListRepository(CartListDataModule cartListDataModule, DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl) {
        return (DarkstoresCartListRepository) Preconditions.checkNotNullFromProvides(cartListDataModule.provideCartListRepository(darkstoresCartListRepositoryImpl));
    }

    public DarkstoresCartListRepository get() {
        return provideCartListRepository(this.module, this.cartListRepositoryImplProvider.get());
    }
}
