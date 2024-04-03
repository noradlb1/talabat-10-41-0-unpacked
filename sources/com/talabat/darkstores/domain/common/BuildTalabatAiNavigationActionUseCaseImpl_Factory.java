package com.talabat.darkstores.domain.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildTalabatAiNavigationActionUseCaseImpl_Factory implements Factory<BuildTalabatAiNavigationActionUseCaseImpl> {
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;

    public BuildTalabatAiNavigationActionUseCaseImpl_Factory(Provider<GetFlutterConfigurationParamsUseCase> provider) {
        this.getFlutterConfigurationParamsProvider = provider;
    }

    public static BuildTalabatAiNavigationActionUseCaseImpl_Factory create(Provider<GetFlutterConfigurationParamsUseCase> provider) {
        return new BuildTalabatAiNavigationActionUseCaseImpl_Factory(provider);
    }

    public static BuildTalabatAiNavigationActionUseCaseImpl newInstance(GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildTalabatAiNavigationActionUseCaseImpl(getFlutterConfigurationParamsUseCase);
    }

    public BuildTalabatAiNavigationActionUseCaseImpl get() {
        return newInstance(this.getFlutterConfigurationParamsProvider.get());
    }
}
