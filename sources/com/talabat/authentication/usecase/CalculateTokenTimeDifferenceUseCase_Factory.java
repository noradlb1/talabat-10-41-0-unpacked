package com.talabat.authentication.usecase;

import com.talabat.authentication.token.data.remote.impl.JwtPayloadDecoder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CalculateTokenTimeDifferenceUseCase_Factory implements Factory<CalculateTokenTimeDifferenceUseCase> {
    private final Provider<DeviceTimeProvider> deviceTimeProvider;
    private final Provider<IsTokenTimeDifferenceEnabledUseCase> isTokenTimeDifferenceEnabledUseCaseProvider;
    private final Provider<JwtPayloadDecoder> jwtPayloadDecoderProvider;

    public CalculateTokenTimeDifferenceUseCase_Factory(Provider<IsTokenTimeDifferenceEnabledUseCase> provider, Provider<DeviceTimeProvider> provider2, Provider<JwtPayloadDecoder> provider3) {
        this.isTokenTimeDifferenceEnabledUseCaseProvider = provider;
        this.deviceTimeProvider = provider2;
        this.jwtPayloadDecoderProvider = provider3;
    }

    public static CalculateTokenTimeDifferenceUseCase_Factory create(Provider<IsTokenTimeDifferenceEnabledUseCase> provider, Provider<DeviceTimeProvider> provider2, Provider<JwtPayloadDecoder> provider3) {
        return new CalculateTokenTimeDifferenceUseCase_Factory(provider, provider2, provider3);
    }

    public static CalculateTokenTimeDifferenceUseCase newInstance(IsTokenTimeDifferenceEnabledUseCase isTokenTimeDifferenceEnabledUseCase, DeviceTimeProvider deviceTimeProvider2, JwtPayloadDecoder jwtPayloadDecoder) {
        return new CalculateTokenTimeDifferenceUseCase(isTokenTimeDifferenceEnabledUseCase, deviceTimeProvider2, jwtPayloadDecoder);
    }

    public CalculateTokenTimeDifferenceUseCase get() {
        return newInstance(this.isTokenTimeDifferenceEnabledUseCaseProvider.get(), this.deviceTimeProvider.get(), this.jwtPayloadDecoderProvider.get());
    }
}
