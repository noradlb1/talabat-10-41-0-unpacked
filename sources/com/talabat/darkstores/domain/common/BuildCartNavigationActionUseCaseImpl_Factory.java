package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.domain.cart.IsFlutterCartEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildCartNavigationActionUseCaseImpl_Factory implements Factory<BuildCartNavigationActionUseCaseImpl> {
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;
    private final Provider<IsFlutterCartEnabledUseCase> isFlutterCartEnabledProvider;

    public BuildCartNavigationActionUseCaseImpl_Factory(Provider<IsFlutterCartEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        this.isFlutterCartEnabledProvider = provider;
        this.getFlutterConfigurationParamsProvider = provider2;
    }

    public static BuildCartNavigationActionUseCaseImpl_Factory create(Provider<IsFlutterCartEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        return new BuildCartNavigationActionUseCaseImpl_Factory(provider, provider2);
    }

    public static BuildCartNavigationActionUseCaseImpl newInstance(IsFlutterCartEnabledUseCase isFlutterCartEnabledUseCase, GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildCartNavigationActionUseCaseImpl(isFlutterCartEnabledUseCase, getFlutterConfigurationParamsUseCase);
    }

    public BuildCartNavigationActionUseCaseImpl get() {
        return newInstance(this.isFlutterCartEnabledProvider.get(), this.getFlutterConfigurationParamsProvider.get());
    }
}
