package com.talabat.darkstores.di;

import com.talabat.darkstores.domain.basket.IsBasketUpsellExperimentEnabledUseCase;
import com.talabat.darkstores.domain.basket.IsBasketUpsellExperimentEnabledUseCaseImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellExperimentEnabledUseCaseImplFactory implements Factory<IsBasketUpsellExperimentEnabledUseCase> {
    private final Provider<IsBasketUpsellExperimentEnabledUseCaseImpl> implProvider;

    public DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellExperimentEnabledUseCaseImplFactory(Provider<IsBasketUpsellExperimentEnabledUseCaseImpl> provider) {
        this.implProvider = provider;
    }

    public static DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellExperimentEnabledUseCaseImplFactory create(Provider<IsBasketUpsellExperimentEnabledUseCaseImpl> provider) {
        return new DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellExperimentEnabledUseCaseImplFactory(provider);
    }

    public static IsBasketUpsellExperimentEnabledUseCase providesIsBasketUpsellExperimentEnabledUseCaseImpl(IsBasketUpsellExperimentEnabledUseCaseImpl isBasketUpsellExperimentEnabledUseCaseImpl) {
        return (IsBasketUpsellExperimentEnabledUseCase) Preconditions.checkNotNullFromProvides(DarkstoreBasketUpsellModule.INSTANCE.providesIsBasketUpsellExperimentEnabledUseCaseImpl(isBasketUpsellExperimentEnabledUseCaseImpl));
    }

    public IsBasketUpsellExperimentEnabledUseCase get() {
        return providesIsBasketUpsellExperimentEnabledUseCaseImpl(this.implProvider.get());
    }
}
