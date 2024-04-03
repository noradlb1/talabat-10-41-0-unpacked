package com.talabat.feature.activecarts.data.di;

import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl;
import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class ActiveCartsDataModule_ProvideActiveCartRepositoryFactory implements Factory<ActiveCartRepository> {
    private final Provider<ActiveCartInfoRepositoryImpl> implProvider;
    private final ActiveCartsDataModule module;

    public ActiveCartsDataModule_ProvideActiveCartRepositoryFactory(ActiveCartsDataModule activeCartsDataModule, Provider<ActiveCartInfoRepositoryImpl> provider) {
        this.module = activeCartsDataModule;
        this.implProvider = provider;
    }

    public static ActiveCartsDataModule_ProvideActiveCartRepositoryFactory create(ActiveCartsDataModule activeCartsDataModule, Provider<ActiveCartInfoRepositoryImpl> provider) {
        return new ActiveCartsDataModule_ProvideActiveCartRepositoryFactory(activeCartsDataModule, provider);
    }

    public static ActiveCartRepository provideActiveCartRepository(ActiveCartsDataModule activeCartsDataModule, ActiveCartInfoRepositoryImpl activeCartInfoRepositoryImpl) {
        return (ActiveCartRepository) Preconditions.checkNotNullFromProvides(activeCartsDataModule.provideActiveCartRepository(activeCartInfoRepositoryImpl));
    }

    public ActiveCartRepository get() {
        return provideActiveCartRepository(this.module, this.implProvider.get());
    }
}
