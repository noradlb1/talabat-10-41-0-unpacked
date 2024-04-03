package com.talabat.darkstores.domain.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildDeliveryFeeTierNavigationUseCaseImpl_Factory implements Factory<BuildDeliveryFeeTierNavigationUseCaseImpl> {
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;

    public BuildDeliveryFeeTierNavigationUseCaseImpl_Factory(Provider<GetFlutterConfigurationParamsUseCase> provider) {
        this.getFlutterConfigurationParamsProvider = provider;
    }

    public static BuildDeliveryFeeTierNavigationUseCaseImpl_Factory create(Provider<GetFlutterConfigurationParamsUseCase> provider) {
        return new BuildDeliveryFeeTierNavigationUseCaseImpl_Factory(provider);
    }

    public static BuildDeliveryFeeTierNavigationUseCaseImpl newInstance(GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildDeliveryFeeTierNavigationUseCaseImpl(getFlutterConfigurationParamsUseCase);
    }

    public BuildDeliveryFeeTierNavigationUseCaseImpl get() {
        return newInstance(this.getFlutterConfigurationParamsProvider.get());
    }
}
