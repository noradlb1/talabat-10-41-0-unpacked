package com.talabat.feature.darkstorestooltip.presentation.di;

import com.talabat.feature.darkstorestooltip.DarkstoresTooltipRepositoryImpl;
import com.talabat.feature.darkstorestooltip.domain.di.DarkstoresTooltipRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresTooltipDataModule_ProvideRepositoryFactory implements Factory<DarkstoresTooltipRepository> {
    private final Provider<DarkstoresTooltipRepositoryImpl> implProvider;

    public DarkstoresTooltipDataModule_ProvideRepositoryFactory(Provider<DarkstoresTooltipRepositoryImpl> provider) {
        this.implProvider = provider;
    }

    public static DarkstoresTooltipDataModule_ProvideRepositoryFactory create(Provider<DarkstoresTooltipRepositoryImpl> provider) {
        return new DarkstoresTooltipDataModule_ProvideRepositoryFactory(provider);
    }

    public static DarkstoresTooltipRepository provideRepository(DarkstoresTooltipRepositoryImpl darkstoresTooltipRepositoryImpl) {
        return (DarkstoresTooltipRepository) Preconditions.checkNotNullFromProvides(DarkstoresTooltipDataModule.INSTANCE.provideRepository(darkstoresTooltipRepositoryImpl));
    }

    public DarkstoresTooltipRepository get() {
        return provideRepository(this.implProvider.get());
    }
}
