package com.talabat.feature.darkstorescarrierbag.presentation.di;

import com.talabat.feature.darkstorescarrierbag.data.DarkstoresCarrierBagRepositoryImpl;
import com.talabat.feature.darkstorescarrierbag.domain.repository.DarkstoresCarrierBagRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresTooltipDataModule_ProvideRepositoryFactory implements Factory<DarkstoresCarrierBagRepository> {
    private final Provider<DarkstoresCarrierBagRepositoryImpl> implProvider;

    public DarkstoresTooltipDataModule_ProvideRepositoryFactory(Provider<DarkstoresCarrierBagRepositoryImpl> provider) {
        this.implProvider = provider;
    }

    public static DarkstoresTooltipDataModule_ProvideRepositoryFactory create(Provider<DarkstoresCarrierBagRepositoryImpl> provider) {
        return new DarkstoresTooltipDataModule_ProvideRepositoryFactory(provider);
    }

    public static DarkstoresCarrierBagRepository provideRepository(DarkstoresCarrierBagRepositoryImpl darkstoresCarrierBagRepositoryImpl) {
        return (DarkstoresCarrierBagRepository) Preconditions.checkNotNullFromProvides(DarkstoresTooltipDataModule.INSTANCE.provideRepository(darkstoresCarrierBagRepositoryImpl));
    }

    public DarkstoresCarrierBagRepository get() {
        return provideRepository(this.implProvider.get());
    }
}
