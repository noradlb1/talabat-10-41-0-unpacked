package com.talabat.authentication.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsTokenExpiredUseCase_Factory implements Factory<IsTokenExpiredUseCase> {
    private final Provider<DeviceTimeProvider> deviceTimeProvider;
    private final Provider<IsTokenTimeDifferenceEnabledUseCase> isTokenTimeDifferenceEnabledUseCaseProvider;

    public IsTokenExpiredUseCase_Factory(Provider<IsTokenTimeDifferenceEnabledUseCase> provider, Provider<DeviceTimeProvider> provider2) {
        this.isTokenTimeDifferenceEnabledUseCaseProvider = provider;
        this.deviceTimeProvider = provider2;
    }

    public static IsTokenExpiredUseCase_Factory create(Provider<IsTokenTimeDifferenceEnabledUseCase> provider, Provider<DeviceTimeProvider> provider2) {
        return new IsTokenExpiredUseCase_Factory(provider, provider2);
    }

    public static IsTokenExpiredUseCase newInstance(IsTokenTimeDifferenceEnabledUseCase isTokenTimeDifferenceEnabledUseCase, DeviceTimeProvider deviceTimeProvider2) {
        return new IsTokenExpiredUseCase(isTokenTimeDifferenceEnabledUseCase, deviceTimeProvider2);
    }

    public IsTokenExpiredUseCase get() {
        return newInstance(this.isTokenTimeDifferenceEnabledUseCaseProvider.get(), this.deviceTimeProvider.get());
    }
}
