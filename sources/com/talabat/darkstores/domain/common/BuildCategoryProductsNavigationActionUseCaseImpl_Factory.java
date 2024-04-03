package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.domain.products.CheckFlutterCategoryProductsEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildCategoryProductsNavigationActionUseCaseImpl_Factory implements Factory<BuildCategoryProductsNavigationActionUseCaseImpl> {
    private final Provider<CheckFlutterCategoryProductsEnabledUseCase> checkFlutterCategoryProductsEnabledProvider;
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;

    public BuildCategoryProductsNavigationActionUseCaseImpl_Factory(Provider<CheckFlutterCategoryProductsEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        this.checkFlutterCategoryProductsEnabledProvider = provider;
        this.getFlutterConfigurationParamsProvider = provider2;
    }

    public static BuildCategoryProductsNavigationActionUseCaseImpl_Factory create(Provider<CheckFlutterCategoryProductsEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        return new BuildCategoryProductsNavigationActionUseCaseImpl_Factory(provider, provider2);
    }

    public static BuildCategoryProductsNavigationActionUseCaseImpl newInstance(CheckFlutterCategoryProductsEnabledUseCase checkFlutterCategoryProductsEnabledUseCase, GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildCategoryProductsNavigationActionUseCaseImpl(checkFlutterCategoryProductsEnabledUseCase, getFlutterConfigurationParamsUseCase);
    }

    public BuildCategoryProductsNavigationActionUseCaseImpl get() {
        return newInstance(this.checkFlutterCategoryProductsEnabledProvider.get(), this.getFlutterConfigurationParamsProvider.get());
    }
}
