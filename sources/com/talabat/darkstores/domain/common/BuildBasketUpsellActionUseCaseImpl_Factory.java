package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.domain.basket.IsBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.basket.IsBasketUpsellExperimentEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildBasketUpsellActionUseCaseImpl_Factory implements Factory<BuildBasketUpsellActionUseCaseImpl> {
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;
    private final Provider<IsBasketUpsellBottomSheetShownUseCase> isBasketUpsellBottomSheetShownProvider;
    private final Provider<IsBasketUpsellExperimentEnabledUseCase> isBasketUpsellEnabledProvider;

    public BuildBasketUpsellActionUseCaseImpl_Factory(Provider<IsBasketUpsellExperimentEnabledUseCase> provider, Provider<IsBasketUpsellBottomSheetShownUseCase> provider2, Provider<GetFlutterConfigurationParamsUseCase> provider3) {
        this.isBasketUpsellEnabledProvider = provider;
        this.isBasketUpsellBottomSheetShownProvider = provider2;
        this.getFlutterConfigurationParamsProvider = provider3;
    }

    public static BuildBasketUpsellActionUseCaseImpl_Factory create(Provider<IsBasketUpsellExperimentEnabledUseCase> provider, Provider<IsBasketUpsellBottomSheetShownUseCase> provider2, Provider<GetFlutterConfigurationParamsUseCase> provider3) {
        return new BuildBasketUpsellActionUseCaseImpl_Factory(provider, provider2, provider3);
    }

    public static BuildBasketUpsellActionUseCaseImpl newInstance(IsBasketUpsellExperimentEnabledUseCase isBasketUpsellExperimentEnabledUseCase, IsBasketUpsellBottomSheetShownUseCase isBasketUpsellBottomSheetShownUseCase, GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildBasketUpsellActionUseCaseImpl(isBasketUpsellExperimentEnabledUseCase, isBasketUpsellBottomSheetShownUseCase, getFlutterConfigurationParamsUseCase);
    }

    public BuildBasketUpsellActionUseCaseImpl get() {
        return newInstance(this.isBasketUpsellEnabledProvider.get(), this.isBasketUpsellBottomSheetShownProvider.get(), this.getFlutterConfigurationParamsProvider.get());
    }
}
