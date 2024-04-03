package com.talabat.darkstores.domain.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildVoucherProductListingNavigationUseCaseImpl_Factory implements Factory<BuildVoucherProductListingNavigationUseCaseImpl> {
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;

    public BuildVoucherProductListingNavigationUseCaseImpl_Factory(Provider<GetFlutterConfigurationParamsUseCase> provider) {
        this.getFlutterConfigurationParamsProvider = provider;
    }

    public static BuildVoucherProductListingNavigationUseCaseImpl_Factory create(Provider<GetFlutterConfigurationParamsUseCase> provider) {
        return new BuildVoucherProductListingNavigationUseCaseImpl_Factory(provider);
    }

    public static BuildVoucherProductListingNavigationUseCaseImpl newInstance(GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildVoucherProductListingNavigationUseCaseImpl(getFlutterConfigurationParamsUseCase);
    }

    public BuildVoucherProductListingNavigationUseCaseImpl get() {
        return newInstance(this.getFlutterConfigurationParamsProvider.get());
    }
}
