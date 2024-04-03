package com.talabat.darkstores.di;

import com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCase;
import com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCaseImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoreBasketUpsellModule_ProvidesBuildBasketUpsellActionUseCaseImplFactory implements Factory<BuildBasketUpsellActionUseCase> {
    private final Provider<BuildBasketUpsellActionUseCaseImpl> implProvider;

    public DarkstoreBasketUpsellModule_ProvidesBuildBasketUpsellActionUseCaseImplFactory(Provider<BuildBasketUpsellActionUseCaseImpl> provider) {
        this.implProvider = provider;
    }

    public static DarkstoreBasketUpsellModule_ProvidesBuildBasketUpsellActionUseCaseImplFactory create(Provider<BuildBasketUpsellActionUseCaseImpl> provider) {
        return new DarkstoreBasketUpsellModule_ProvidesBuildBasketUpsellActionUseCaseImplFactory(provider);
    }

    public static BuildBasketUpsellActionUseCase providesBuildBasketUpsellActionUseCaseImpl(BuildBasketUpsellActionUseCaseImpl buildBasketUpsellActionUseCaseImpl) {
        return (BuildBasketUpsellActionUseCase) Preconditions.checkNotNullFromProvides(DarkstoreBasketUpsellModule.INSTANCE.providesBuildBasketUpsellActionUseCaseImpl(buildBasketUpsellActionUseCaseImpl));
    }

    public BuildBasketUpsellActionUseCase get() {
        return providesBuildBasketUpsellActionUseCaseImpl(this.implProvider.get());
    }
}
