package com.talabat.darkstores.domain.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildSearchNavigationActionUseCaseImpl_Factory implements Factory<BuildSearchNavigationActionUseCaseImpl> {
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;

    public BuildSearchNavigationActionUseCaseImpl_Factory(Provider<GetFlutterConfigurationParamsUseCase> provider) {
        this.getFlutterConfigurationParamsProvider = provider;
    }

    public static BuildSearchNavigationActionUseCaseImpl_Factory create(Provider<GetFlutterConfigurationParamsUseCase> provider) {
        return new BuildSearchNavigationActionUseCaseImpl_Factory(provider);
    }

    public static BuildSearchNavigationActionUseCaseImpl newInstance(GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildSearchNavigationActionUseCaseImpl(getFlutterConfigurationParamsUseCase);
    }

    public BuildSearchNavigationActionUseCaseImpl get() {
        return newInstance(this.getFlutterConfigurationParamsProvider.get());
    }
}
